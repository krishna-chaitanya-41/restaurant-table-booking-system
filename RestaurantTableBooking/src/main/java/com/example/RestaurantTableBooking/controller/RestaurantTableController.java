package com.example.RestaurantTableBooking.controller;


import com.example.RestaurantTableBooking.dto.RestaurantTableDTO;
import com.example.RestaurantTableBooking.entity.RestaurantTable;
import com.example.RestaurantTableBooking.service.RestaurantTableService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants/tables")
public class RestaurantTableController {
    @Autowired
    private RestaurantTableService restaurantTableService;

    @PostMapping
    public ResponseEntity<RestaurantTable> createTable(@Valid @RequestBody RestaurantTableDTO dto){
        RestaurantTable table=restaurantTableService.createTable(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(table);
    }
    @GetMapping("/{id}")
    public ResponseEntity<RestaurantTable> getTableById(@PathVariable Long id){
        RestaurantTable table=restaurantTableService.getTableById(id);
        return ResponseEntity.ok(table);
    }
    @GetMapping
    public ResponseEntity<List<RestaurantTable>> getAllTables(){
        List<RestaurantTable> allTables=restaurantTableService.getAllTables();
        return ResponseEntity.ok(allTables);
    }
    @PutMapping("/{id}")
    public ResponseEntity<RestaurantTable> updateTable(@PathVariable Long id,@Valid @RequestBody RestaurantTableDTO dto){
        RestaurantTable table=restaurantTableService.updateTable(id,dto);
        return ResponseEntity.ok(table);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<RestaurantTable> deleteTable(@PathVariable Long id){
        restaurantTableService.deleteTable(id);
        return ResponseEntity.noContent().build();
    }

}
