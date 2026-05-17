package org.example.booter;

import org.example.booter.entity.Room;
import org.example.booter.repository.RoomRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CLRunner implements CommandLineRunner {

    private final RoomRespository roomRespository;

    public CLRunner(RoomRespository roomRespository) {
        this.roomRespository = roomRespository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Room> rooms = this.roomRespository.findAll();
        Optional<Room> room = this.roomRespository.findByRoomNumberIgnoreCase("p1");
        System.out.println(room);
        rooms.forEach(System.out::println);
    }
}
