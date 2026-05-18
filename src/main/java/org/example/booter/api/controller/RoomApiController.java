package org.example.booter.api.controller;

import org.example.booter.entity.Room;
import org.example.booter.repository.RoomRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/api/rooms")
@ResponseBody
public class RoomController {
    private final RoomRepository roomRespository;

    public RoomController(RoomRepository roomRepository, RoomRepository roomRespository) {
        this.roomRespository = roomRespository;
    }

    @GetMapping
    public List<Room> getRooms() {
        return this.roomRespository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Room> getRoom(@PathVariable("id") Integer id) {
        return this.roomRespository.findById(id);
    }

    @PostMapping
    public String saveRoom(@RequestBody Room room) {
        this.roomRespository.save(room);
        return "Save Success";
    }

    @PutMapping("/{id}")
    public String updateRoom(@RequestBody Room room, @PathVariable("id") Integer id) {
        Optional<Room> current = this.roomRespository.findById(id);
        if (!current.isEmpty()) {
            current.get().setName(room.getName());
            current.get().setRoomNumber(room.getRoomNumber());
            current.get().setBedInfo(room.getBedInfo());
            this.roomRespository.save(current.get());
        }
        return "Updated Successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteRoom(@RequestParam Integer id) {
        String message = "The ID doesn't Exist.";
        Optional<Room> room = this.roomRespository.findById(id);
        if (!room.isEmpty()) {
            this.roomRespository.deleteById(room.get().getId());
            message = "Room Deleted Successfully!";
        }
        return message;
    }
}
