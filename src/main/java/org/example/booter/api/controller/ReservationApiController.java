package org.example.booter.api.controller;

import org.example.booter.entity.Reservation;
import org.example.booter.repository.ReservationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservationApiController {

    private final ReservationRepository reservationRepository;

    public ReservationApiController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping
    public List<Reservation> rservations() {
        return this.reservationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Reservation reservation(@PathVariable("id") Integer id) {
        Optional<Reservation> reservation = this.reservationRepository.findById(id);
        if (!reservation.isEmpty()) {
            return reservation.get();
        }
        return null;
    }

    @PostMapping
    public String saveReservation(@RequestBody Reservation reservation) {
        this.reservationRepository.save(reservation);
        return "Saved Successfully!";
    }

    @PutMapping("/{id}")
    public String updateReservation(@PathVariable("id") Integer id, @RequestBody Reservation reservation) {
        Optional<Reservation> savedReservation = this.reservationRepository.findById(id);
        if (!savedReservation.isEmpty()) {
            Reservation currentReservation = savedReservation.get();
            currentReservation.setGuestId(reservation.getGuestId());
            currentReservation.setRoomId(reservation.getRoomId());
            currentReservation.setResDate(reservation.getResDate());
            this.reservationRepository.save(currentReservation);
        }
        return "Updated Successfully";
    }
}
