package com.gmail.shelkovich.anton.service.Exception;

public class IllegalOrderStatusException extends Exception {
    public IllegalOrderStatusException() {
        super();
    }

    public IllegalOrderStatusException(String message) {
        super(message);
    }

    public IllegalOrderStatusException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalOrderStatusException(Throwable cause) {
        super(cause);
    }

    protected IllegalOrderStatusException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
