package org.example.booter.api.controller;

import org.example.booter.entity.Room;
import org.example.booter.repository.RoomRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
@ResponseBody
public class RoomApiController {
    private final RoomRepository roomRepository;

    public RoomApiController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping
    public List<Room> getRooms() {
        return this.roomRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Room> getRoom(@PathVariable("id") Integer id) {
        return this.roomRepository.findById(id);
    }

    @PostMapping
    public String saveRoom(@RequestBody Room room) {
        this.roomRepository.save(room);
        return "Save Success";
    }

    @PutMapping("/{id}")
    public String updateRoom(@RequestBody Room room, @PathVariable("id") Integer id) {
        Optional<Room> current = this.roomRepository.findById(id);
        if (!current.isEmpty()) {
            current.get().setName(room.getName());
            current.get().setRoomNumber(room.getRoomNumber());
            current.get().setBedInfo(room.getBedInfo());
            this.roomRepository.save(current.get());
        }
        return "Updated Successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteRoom(@RequestParam Integer id) {
        String message = "The ID doesn't Exist.";
        Optional<Room> room = this.roomRepository.findById(id);
        if (!room.isEmpty()) {
            this.roomRepository.deleteById(room.get().getId());
            message = "Room Deleted Successfully!";
        }
        return message;
    }
}
