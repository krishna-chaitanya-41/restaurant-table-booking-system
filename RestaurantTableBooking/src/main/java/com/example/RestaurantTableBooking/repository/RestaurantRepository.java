package com.example.RestaurantTableBooking.repository;

import com.example.RestaurantTableBooking.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
