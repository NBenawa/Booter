package org.example.booter.controller;

import org.example.booter.repository.RoomRespository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    private final RoomRespository roomRespository;

    public RoomController(RoomRespository roomRespository) {
        this.roomRespository = roomRespository;
    }

    @GetMapping
    public String rooms(Model model) {
        model.addAttribute("rooms", this.roomRespository.findAll());
        return "rooms";
    }
}
