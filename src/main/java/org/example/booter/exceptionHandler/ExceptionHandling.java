package org.example.booter.exceptionHandler;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandling {
    @ExceptionHandler(GuestNotFoundException.class)
    public ResponseEntity<?> handleGuestNotFoundException(GuestNotFoundException exception) {
        return new ResponseEntity<>(new String[]{"Guest Not Found!", "A Guest with the given id is not in the database.", HttpStatusCode.valueOf(404).toString()}, HttpStatusCode.valueOf(404));
    }

    @ExceptionHandler(ReservationNotFoundException.class)
    public ResponseEntity<?> handleReservationNotFoundException(ReservationNotFoundException exception) {
        return new ResponseEntity<>(new String[]{"Reservation Not Found!", "A Reservation with this id is not in the database.", HttpStatusCode.valueOf(404).toString()}, HttpStatusCode.valueOf(404));
    }

    @ExceptionHandler(RoomNotFoundException.class)
    public ResponseEntity<?> handleRoomNotFoundException(RoomNotFoundException exception) {
        return new ResponseEntity<>(new String[]{"Room Not Found!", "A Room with given id is not found.", HttpStatusCode.valueOf(404).toString()}, HttpStatusCode.valueOf(404));
    }
}
