package com.example.RestaurantTableBooking.exception;

public class TableNotFoundException extends RuntimeException{
    public TableNotFoundException(String message){
        super(message);
    }
}
