package com.example.userregistration;

public class InvalidUserDetailException extends Exception {
    public InvalidUserDetailException(String message) {
        super(message);
    }
}