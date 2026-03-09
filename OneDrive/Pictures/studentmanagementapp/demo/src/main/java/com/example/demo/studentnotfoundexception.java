package com.example.demo;

import org.springframework.http.HttpStatus;

public class studentnotfoundexception extends RuntimeException {
    public studentnotfoundexception(String message, HttpStatus notFound) {
        super(message);
    }
}
