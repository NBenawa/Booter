package org.example.booter.controller;

import org.example.booter.repository.ReservationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;

@Controller
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationRepository reservationRepository;

    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping
    public String reservations(@RequestParam(value = "date", required = false) Date date, Model model) {
        if (date != null) {
            model.addAttribute("reservations", this.reservationRepository.getReservationsByResDate(date));
            model.addAttribute("date", date);
        } else {
            model.addAttribute("reservations", this.reservationRepository.findAll());
            model.addAttribute("date", new Date(System.currentTimeMillis()));
        }
        return "room_reservations";
    }
}
