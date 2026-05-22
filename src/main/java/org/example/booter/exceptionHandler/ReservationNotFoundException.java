package org.example.booter.exceptionHandler;

public class ReservationNotFoundException extends Exception {
    ReservationNotFoundException (String message) {
        super(message);
    }
}
