package com.example.RestaurantTableBooking.service;

import com.example.RestaurantTableBooking.dto.RestaurantDTO;
import com.example.RestaurantTableBooking.entity.Restaurant;
import com.example.RestaurantTableBooking.exception.RestaurantNotFoundException;
import com.example.RestaurantTableBooking.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Restaurant addRestaurant(RestaurantDTO restaurantDTO){
        Restaurant restaurant=new Restaurant();
        restaurant.setName(restaurantDTO.getName());
        restaurant.setAddress(restaurantDTO.getAddress());
        restaurant.setPhoneNumber(restaurantDTO.getPhoneNumber());
        restaurant.setTotalTables(restaurantDTO.getTotalTables());
        return restaurantRepository.save(restaurant);
    }
    @Override
    public List<Restaurant> getAllRestaurants(){
        List<Restaurant> restaurant =restaurantRepository.findAll();
        return restaurant;
    }
    @Override
    public Restaurant getRestaurantById(Long id){
        return restaurantRepository.findById(id).orElseThrow(()-> new RestaurantNotFoundException("Restaurant Not found"));
    }
    @Override
    public Restaurant updateRestaurant(Long id, RestaurantDTO dto){
        Restaurant restaurant= restaurantRepository.findById(id).orElseThrow(()->new RestaurantNotFoundException("Restaurant Not found, updating is impossible"));
        restaurant.setName(dto.getName());
        restaurant.setAddress(dto.getAddress());
        restaurant.setPhoneNumber(dto.getPhoneNumber());
        restaurant.setTotalTables(dto.getTotalTables());
        return restaurantRepository.save(restaurant);
    }
    @Override
    public void deleteRestaurant(Long id){
        Restaurant restaurant=restaurantRepository.findById(id).orElseThrow(()->new RestaurantNotFoundException("Restaurant Not Found, Check Id"));
        restaurantRepository.delete(restaurant);
    }

}
