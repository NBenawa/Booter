package org.example.booter.repository;

import org.example.booter.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository <Reservation, Integer> {
    List<Reservation> getReservationsByResDate(Date resDate);
}
