package com.example.springprojectmain.services.exceptions;

public class BadDataException extends RuntimeException {
    public BadDataException(String message) {
        super(message);
    }
}
