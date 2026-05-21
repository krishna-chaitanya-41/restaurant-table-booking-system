package com.example.RestaurantTableBooking.service;

import com.example.RestaurantTableBooking.dto.RestaurantTableDTO;
import com.example.RestaurantTableBooking.entity.RestaurantTable;

import java.util.List;

public interface RestaurantTableService {
    RestaurantTable createTable(RestaurantTableDTO dto);
    List<RestaurantTable> getAllTables();
    RestaurantTable getTableById(Long id);
    RestaurantTable updateTable(Long id,RestaurantTableDTO dto);
    void deleteTable(Long id);
}
