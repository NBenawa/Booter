package org.example.booter.entity;

import jakarta.persistence.*;

@Entity
@Table(name="rooms")
public class Room {
    @Id
    @Column(name="ROOM_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int room_id;

    @Column(name="NAME")
    private String name;

    @Column(name="ROOM_NUMBER")
    private String roomNumber;

    @Column(name="BED_INFO")
    private String bedInfo;

    @Override
    public String toString() {
        return "Room{" +
                "room_id=" + room_id +
                ", name='" + name + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", bedInfo='" + bedInfo + '\'' +
                '}';
    }
}
