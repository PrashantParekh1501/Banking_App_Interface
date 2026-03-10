package com.example.Teacher_Management_App.exceptions;

import org.springframework.http.HttpStatus;

public class TeacherNotFoundException extends RuntimeException {
    public TeacherNotFoundException(String message) {
        super(message);
    }

    public TeacherNotFoundException(String message, HttpStatus httpStatus) {
        super(message);
    }
}
