package com.example.aiproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) // This will return a 400 response
public class BadDataException extends RuntimeException {
    public BadDataException(String message) {
        super(message);
    }
}
