package com.example.RestaurantTableBooking.service;

import com.example.RestaurantTableBooking.dto.RestaurantDTO;
import com.example.RestaurantTableBooking.entity.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;
public interface RestaurantService {
    Restaurant addRestaurant(RestaurantDTO dto);
    List<Restaurant> getAllRestaurants();
    Restaurant getRestaurantById(Long id);
    Restaurant updateRestaurant(Long id, RestaurantDTO dto);
    void deleteRestaurant(Long id);
}
