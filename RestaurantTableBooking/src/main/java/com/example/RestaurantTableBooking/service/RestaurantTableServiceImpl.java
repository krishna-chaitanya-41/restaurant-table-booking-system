package com.example.RestaurantTableBooking.service;

import com.example.RestaurantTableBooking.dto.RestaurantTableDTO;
import com.example.RestaurantTableBooking.entity.Restaurant;
import com.example.RestaurantTableBooking.entity.RestaurantTable;
import com.example.RestaurantTableBooking.exception.RestaurantNotFoundException;
import com.example.RestaurantTableBooking.exception.TableNotAvailableException;
import com.example.RestaurantTableBooking.exception.TableNotFoundException;
import com.example.RestaurantTableBooking.repository.RestaurantRepository;
import com.example.RestaurantTableBooking.repository.RestaurantTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantTableServiceImpl implements RestaurantTableService{
    @Autowired
    private RestaurantTableRepository restaurantTableRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;


    @Override
    public RestaurantTable createTable(RestaurantTableDTO dto){
        RestaurantTable restaurantTable=new RestaurantTable();
        restaurantTable.setTableNumber(dto.getTableNumber());
        restaurantTable.setCapacity(dto.getCapacity());
        restaurantTable.setAvailable(true);
        Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId())
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found"));
        restaurantTable.setRestaurant(restaurant);
        return restaurantTableRepository.save(restaurantTable);
    }
    @Override
    public RestaurantTable updateTable(Long id,RestaurantTableDTO dto){
        RestaurantTable restaurantTable=restaurantTableRepository.findById(id).orElseThrow(()-> new TableNotFoundException("Table is not found"));
        restaurantTable.setTableNumber(dto.getTableNumber());
        restaurantTable.setCapacity(dto.getCapacity());
        restaurantTable.setAvailable(true);
        Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId())
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found"));
        restaurantTable.setRestaurant(restaurant); // ✅
        return restaurantTableRepository.save(restaurantTable);
    }

    @Override
    public void deleteTable(Long id){
        RestaurantTable restaurantTable=restaurantTableRepository.findById(id).orElseThrow(()->new TableNotFoundException("Table not found"));
        restaurantTableRepository.deleteById(id);
    }
    @Override
    public RestaurantTable getTableById(Long id){
        return restaurantTableRepository.findById(id).orElseThrow(()->new TableNotFoundException("Table Not Found"));
    }
    @Override
    public List<RestaurantTable> getAllTables(){
        return restaurantTableRepository.findAll();
    }


}
