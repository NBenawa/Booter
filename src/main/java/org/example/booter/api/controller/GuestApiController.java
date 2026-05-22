package org.example.booter.api.controller;

import org.example.booter.entity.Guest;
import org.example.booter.exceptionHandler.GuestNotFoundException;
import org.example.booter.repository.GuestRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/guests")
public class GuestApiController {
    private final GuestRepository guestRepository;

    public GuestApiController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @GetMapping
    public List<Guest> guests() {
        return this.guestRepository.findAll();
    }

    @GetMapping("/{id}")
    public Guest guest(@PathVariable("id") Integer id) throws GuestNotFoundException {
        Optional<Guest> guest = this.guestRepository.findById(id);
        if (!guest.isEmpty()) {
            return guest.get();
        } else {
            throw new GuestNotFoundException("Guest Not Found!");
        }
    }

    @PostMapping
    public String addGuest(@RequestBody Guest guest) {
        this.guestRepository.save(guest);
        return "Guest Saved Successfully!";
    }

    @PutMapping("/{id}")
    public String updateGuest(@PathVariable("id") Integer id, @RequestBody Guest guest) {
        Optional<Guest> savedGuest = this.guestRepository.findById(id);
        if (!savedGuest.isEmpty()) {
            Guest currentGuest = savedGuest.get();
            currentGuest.setAddress(guest.getAddress());
            currentGuest.setCountry(guest.getCountry());
            currentGuest.setEmailAddress(guest.getEmailAddress());
            currentGuest.setState(guest.getState());
            currentGuest.setFirstName(guest.getFirstName());
            currentGuest.setLastName(guest.getLastName());
            currentGuest.setPhoneNumber(guest.getPhoneNumber());
            this.guestRepository.save(currentGuest);
        }
        return "Updated Successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteGuest(@PathVariable("id") Integer id) {
        this.guestRepository.deleteById(id);
        return "Deleted Successfully!";
    }
}
