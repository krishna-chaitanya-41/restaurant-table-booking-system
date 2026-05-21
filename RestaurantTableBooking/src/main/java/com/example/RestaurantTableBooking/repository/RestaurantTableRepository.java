package com.example.RestaurantTableBooking.repository;

import com.example.RestaurantTableBooking.entity.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long> {
}
