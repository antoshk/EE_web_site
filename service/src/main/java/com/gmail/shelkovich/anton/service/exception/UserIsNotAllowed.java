package com.gmail.shelkovich.anton.service.exception;

public class UserIsNotAllowed extends RuntimeException {
    public UserIsNotAllowed() {
        super();
    }

    public UserIsNotAllowed(String message) {
        super(message);
    }

    public UserIsNotAllowed(String message, Throwable cause) {
        super(message, cause);
    }

    public UserIsNotAllowed(Throwable cause) {
        super(cause);
    }
}
