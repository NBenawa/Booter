package org.example.booter;

import org.example.booter.entity.Guest;
import org.example.booter.entity.Reservation;
import org.example.booter.entity.Room;
import org.example.booter.repository.GuestRepository;
import org.example.booter.repository.ReservationRepository;
import org.example.booter.repository.RoomRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Component
public class CLRunner implements CommandLineRunner {

    private final RoomRespository roomRespository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    public CLRunner(RoomRespository roomRespository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRespository = roomRespository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Room> rooms = this.roomRespository.findAll();
        Optional<Room> room = this.roomRespository.findByRoomNumberIgnoreCase("p1");
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
