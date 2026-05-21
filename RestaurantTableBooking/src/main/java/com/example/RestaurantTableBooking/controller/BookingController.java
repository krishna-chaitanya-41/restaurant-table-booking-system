package com.example.RestaurantTableBooking.controller;

import com.example.RestaurantTableBooking.dto.BookingDTO;
import com.example.RestaurantTableBooking.entity.Booking;
import com.example.RestaurantTableBooking.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> createBooking(@Valid @RequestBody BookingDTO dto){
        Booking newBooking=bookingService.createBooking(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBooking);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id){

        return ResponseEntity.ok(bookingService.getBookingById(id));
    }
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings(){
        List<Booking> allBookings=bookingService.getAllBookings();
        return ResponseEntity.ok(allBookings);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id,@Valid @RequestBody BookingDTO dto){
        Booking updatedBooking=bookingService.updateBooking(id,dto);
        return ResponseEntity.ok(updatedBooking);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id){
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Booking>> getBookingsByRestaurant(@PathVariable Long restaurantId) {
        return ResponseEntity.ok(bookingService.findByRestaurantId(restaurantId));
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Booking>> getBookingsByDate(@PathVariable LocalDate date) {
        return ResponseEntity.ok(bookingService.findByBookingDate(date));
    }
}
