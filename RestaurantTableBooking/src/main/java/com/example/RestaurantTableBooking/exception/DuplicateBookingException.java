package com.example.RestaurantTableBooking.exception;

public class DuplicateBookingException extends RuntimeException{
    public DuplicateBookingException(String message){
        super(message);
    }
}
