package com.example.carmanagement.exception;

public class TripIsFullException extends RuntimeException{
    public TripIsFullException(String message) {
        super(message);
    }
}
