package com.example.RestaurantTableBooking.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RestaurantNotFoundException.class)
    public ResponseEntity<String> handleRestaurantNotFound(RestaurantNotFoundException e){
        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler(DuplicateBookingException.class)
    public ResponseEntity<String> handleDuplicateBooking(DuplicateBookingException e){
        return ResponseEntity.status(409).body(e.getMessage());
    }
    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<String> handleBookingNotFound(BookingNotFoundException e){
        return ResponseEntity.status(404).body(e.getMessage());
    }
    @ExceptionHandler(TableNotAvailableException.class)
    public ResponseEntity<String> handleTableNotAvailable(TableNotAvailableException e){
        return ResponseEntity.status(400).body(e.getMessage());
    }
    @ExceptionHandler(TableNotFoundException.class)
    public ResponseEntity<String> handleTableNotFound(TableNotFoundException e){
        return ResponseEntity.status(404).body(e.getMessage());
    }
}
