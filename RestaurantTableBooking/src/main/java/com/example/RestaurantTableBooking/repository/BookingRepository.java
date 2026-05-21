package com.example.RestaurantTableBooking.repository;

import com.example.RestaurantTableBooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByRestaurantId(Long restaurantId);
    List<Booking> findByBookingDate(LocalDate date);
    Booking findByBookingTime(LocalTime time);
}
