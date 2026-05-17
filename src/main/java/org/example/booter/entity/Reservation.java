package org.example.booter.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RESERVATION_ID")
    private String reservationId;

    @Column(name = "ROOM_ID")
    private String roomId;

    @Column(name = "GUEST_ID")
    private String guestId;

    @Column(name = "RES_DATE")
    private Date resDate;

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId='" + reservationId + '\'' +
                ", roomId='" + roomId + '\'' +
                ", guestId='" + guestId + '\'' +
                ", resDate='" + resDate + '\'' +
                '}';
    }
}
