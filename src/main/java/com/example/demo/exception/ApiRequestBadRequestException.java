package com.example.demo.exception;

public class ApiRequestBadRequestException extends RuntimeException{
    public ApiRequestBadRequestException(String message) {
        super(message);
    }

    public ApiRequestBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
