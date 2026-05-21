package com.example.RestaurantTableBooking.service;

import com.example.RestaurantTableBooking.dto.BookingDTO;
import com.example.RestaurantTableBooking.entity.Booking;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface BookingService  {
    Booking createBooking(BookingDTO dto);
    void deleteBooking(Long id);
    Booking getBookingById(Long id);
    List<Booking> getAllBookings();
    Booking updateBooking(Long id,BookingDTO dto);
    List<Booking> findByRestaurantId(Long id);
    List<Booking> findByBookingDate(LocalDate date);
    Booking findByBookingTime(LocalTime time);
}
