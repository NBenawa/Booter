package org.example.booter.exceptionHandler;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandling {
    @ExceptionHandler(GuestNotFoundException.class)
    public ResponseEntity<?> handleGuestNotFoundException(GuestNotFoundException exception) {
        return new ResponseEntity<>(new String[]{"Guest Not Found!", "A Guest with the given id is not in the database.", HttpStatusCode.valueOf(404).toString()}, HttpStatusCode.valueOf(404));
    }
}
