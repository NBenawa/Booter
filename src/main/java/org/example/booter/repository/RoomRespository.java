package org.example.booter.repository;

import org.example.booter.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRespository extends JpaRepository<Room, Integer> {
    Optional<Room> findByRoomNumberIgnoreCase(String roomNumber);
}
