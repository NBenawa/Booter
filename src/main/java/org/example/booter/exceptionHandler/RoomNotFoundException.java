package org.example.booter.exceptionHandler;

public class RoomNotFoundException extends Exception {
    RoomNotFoundException(String message) {
        super(message);
    }
}
