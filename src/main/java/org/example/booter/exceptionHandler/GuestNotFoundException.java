package org.example.booter.exceptionHandler;

public class GuestNotFoundException extends Exception {
    public GuestNotFoundException(String message) {
        super(message);
    }
}
