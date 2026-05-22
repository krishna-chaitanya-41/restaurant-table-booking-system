package com.example.RestaurantTableBooking.service;


import com.example.RestaurantTableBooking.dto.BookingDTO;
import com.example.RestaurantTableBooking.entity.Booking;
import com.example.RestaurantTableBooking.entity.Restaurant;
import com.example.RestaurantTableBooking.entity.RestaurantTable;
import com.example.RestaurantTableBooking.exception.BookingNotFoundException;
import com.example.RestaurantTableBooking.exception.RestaurantNotFoundException;
import com.example.RestaurantTableBooking.exception.TableNotAvailableException;
import com.example.RestaurantTableBooking.exception.TableNotFoundException;
import com.example.RestaurantTableBooking.repository.BookingRepository;
import com.example.RestaurantTableBooking.repository.RestaurantRepository;
import com.example.RestaurantTableBooking.repository.RestaurantTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{


    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private RestaurantTableRepository restaurantTableRepository;

    public Booking createBooking(BookingDTO dto){
        Booking booking=new Booking();
        RestaurantTable restaurantTable=restaurantTableRepository.findById(dto.getRestaurantTableId()).orElseThrow(()->new TableNotFoundException("Table Not Found"));
        Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId()).orElseThrow(() -> new RestaurantNotFoundException("Restaurant Not found to book table"));
        if(!restaurantTable.isAvailable()){
            throw new TableNotAvailableException("Table is already Booked");
        }
        booking.setCustomerName(dto.getCustomerName());
            booking.setCustomerPhone(dto.getCustomerPhone());
            booking.setBookingDate(dto.getBookingDate());
            booking.setBookingDuration(dto.getBookingDuration());
            booking.setBookingTime(dto.getBookingTime());
            booking.setStatus(Status.BOOKED);
            booking.setRestaurant(restaurant);
            booking.setRestaurantTable(restaurantTable);
            booking.setNumberOfGuests(dto.getNumberOfGuests());
            restaurantTable.setAvailable(false);
            restaurantTableRepository.save(restaurantTable);
            return bookingRepository.save(booking);

    }
    public Booking updateBooking(Long id,BookingDTO dto){
        Booking booking=bookingRepository.findById(id).orElseThrow(()->new BookingNotFoundException("Booking not found with given id"));
        RestaurantTable restaurantTable=restaurantTableRepository.findById(dto.getRestaurantTableId()).orElseThrow(()->new TableNotFoundException("Table not found to book"));
        Restaurant restaurant=restaurantRepository.findById(dto.getRestaurantId()).orElseThrow(()->new RestaurantNotFoundException("Restaurant Not found to book table"));
        RestaurantTable oldTable = booking.getRestaurantTable();
        if (oldTable != null && oldTable.getId() != restaurantTable.getId()) {
            oldTable.setAvailable(true);
            restaurantTableRepository.save(oldTable);
        }
        if(!restaurantTable.isAvailable()){
            throw new TableNotAvailableException("Table is already Booked");
        }
        booking.setCustomerName(dto.getCustomerName());
        booking.setCustomerPhone(dto.getCustomerPhone());
        booking.setBookingDate(dto.getBookingDate());
        booking.setBookingDuration(dto.getBookingDuration());
        booking.setBookingTime(dto.getBookingTime());
        booking.setStatus(Status.BOOKED);
        booking.setRestaurant(restaurant);
        booking.setRestaurantTable(restaurantTable);
        booking.setNumberOfGuests(dto.getNumberOfGuests());
        restaurantTable.setAvailable(false);
        restaurantTableRepository.save(restaurantTable);
        return bookingRepository.save(booking);
    }
    public void deleteBooking(Long id){
        Booking booking=bookingRepository.findById(id).orElseThrow(()-> new BookingNotFoundException("booking not found with provided id to delete"));
        booking.setStatus(Status.CANCELLED);
        booking.getRestaurantTable().setAvailable(true);
        restaurantTableRepository.save(booking.getRestaurantTable());
        bookingRepository.save(booking);
    }
    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }
    public Booking getBookingById(Long id){
        return bookingRepository.findById(id).orElseThrow(()->new BookingNotFoundException("Booking not found to fetch"));
    }
    public List<Booking> findByRestaurantId(Long id){
        List<Booking> bookings=new ArrayList<>(bookingRepository.findByRestaurantId(id));
        return bookings;

    }
    public List<Booking> findByBookingDate(LocalDate date){
        List<Booking> bookings= new ArrayList<>(bookingRepository.findByBookingDate(date));
        return bookings;
    }
    public Booking findByBookingTime(LocalTime time){
        Booking bookings=bookingRepository.findByBookingTime(time);
        return  bookings;
    }
}
