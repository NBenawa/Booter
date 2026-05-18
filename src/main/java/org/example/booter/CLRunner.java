package org.example.booter;

import org.example.booter.entity.Guest;
import org.example.booter.entity.Reservation;
import org.example.booter.entity.Room;
import org.example.booter.repository.GuestRepository;
import org.example.booter.repository.ReservationRepository;
import org.example.booter.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CLRunner implements CommandLineRunner {

    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    public CLRunner(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Room> rooms = this.roomRepository.findAll();
        Optional<Room> room = this.roomRepository.findByRoomNumberIgnoreCase("p1");
        System.out.println(room);
        rooms.forEach(System.out::println);

        List<Guest> guests = this.guestRepository.findAll();
        System.out.println("Guests");
        guests.forEach(System.out::println);

        List<Reservation> reservations = this.reservationRepository.findAll();
        System.out.println("Reservations");
        guests.forEach(System.out::println);
    }
}
