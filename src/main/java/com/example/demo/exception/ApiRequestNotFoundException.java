package com.example.demo.exception;

public class ApiRequestNotFoundException extends RuntimeException {
    public ApiRequestNotFoundException(String message) {
        super(message);
    }

    public ApiRequestNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
