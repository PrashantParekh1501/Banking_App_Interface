package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

public class existstudentexception extends RuntimeException {
    public existstudentexception(String message, HttpStatus badRequest) {
        super(message);
    }
}
