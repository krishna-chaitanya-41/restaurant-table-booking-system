package com.example.RestaurantTableBooking.exception;

public class TableNotAvailableException extends RuntimeException{
    public TableNotAvailableException(String message){
        super(message);
    }
}
