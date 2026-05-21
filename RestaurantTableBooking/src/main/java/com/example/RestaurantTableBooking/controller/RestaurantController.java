package com.example.RestaurantTableBooking.controller;


import com.example.RestaurantTableBooking.dto.RestaurantDTO;
import com.example.RestaurantTableBooking.entity.Restaurant;
import com.example.RestaurantTableBooking.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<Restaurant> addRestaurant(@Valid @RequestBody RestaurantDTO dto){
        Restaurant result=restaurantService.addRestaurant(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants(){
        List<Restaurant> restaurants=restaurantService.getAllRestaurants();
        return ResponseEntity.ok(restaurants);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@Valid @PathVariable Long id){
        Restaurant restaurant=restaurantService.getRestaurantById(id);
        return ResponseEntity.ok(restaurant);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id,@Valid @RequestBody RestaurantDTO dto){
        Restaurant restaurant=restaurantService.updateRestaurant(id,dto);
        return ResponseEntity.ok(restaurant);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Restaurant> deleteRestaurant(@Valid @PathVariable Long id){
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();

    }
}
