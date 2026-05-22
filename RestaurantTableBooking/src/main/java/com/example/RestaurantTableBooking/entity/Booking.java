package com.example.RestaurantTableBooking.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="TableBooking")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="customer_name")
    @NotBlank(message = "customer name is required")
    private String customerName;

    @Column(name="customer_number")
    @NotBlank(message = "customer phone number is required")
    @Pattern(regexp = "^[6-9]\\d{9}$")
    private String customerPhone;

    @NotNull(message = "Booking Date is required")
    private LocalDate bookingDate;

    @NotNull(message = "Booking time is required")
    private LocalTime bookingTime;

    @NotNull(message = "booking duration is required")
    @Min(value=15,message = "minimum duration is 15 minutes")
    @Column(name="booking_duration")
    private Integer bookingDuration;

    @NotNull(message = "number of guests is required")
    @Min(value = 1,message = "minimum 1 guest is required")
    @Max(value = 10,message = "maximum 10 guests are allowed(if more add one more booking)")
    @Column(name="number_of_Guests")
    private Integer numberOfGuests;

    @Column(name="table_status")
    private Status status=Status.PENDING;

    @ManyToOne
    @JoinColumn(name="restaurantTable_id")
    private RestaurantTable restaurantTable;

    @ManyToOne
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;
}
