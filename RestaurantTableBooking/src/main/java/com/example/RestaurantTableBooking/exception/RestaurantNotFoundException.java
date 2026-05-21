package com.example.RestaurantTableBooking.exception;

public class RestaurantNotFoundException extends RuntimeException{
        public RestaurantNotFoundException(String message){
            super(message);
        }
    }

