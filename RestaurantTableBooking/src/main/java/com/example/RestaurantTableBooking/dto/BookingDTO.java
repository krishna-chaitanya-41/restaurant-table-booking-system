package com.example.RestaurantTableBooking.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDTO {

    @NotBlank(message = "customer name is required")
    private String customerName;

    @NotBlank(message = "customer phone number is required")
    private String customerPhone;

    @NotNull(message = "Booking Date is required")
    private LocalDate bookingDate;

    @NotNull(message = "Booking time is required")
    private LocalTime bookingTime;

    @NotNull(message = "booking duration is required")
    private Integer bookingDuration;

    @NotNull(message = "number of guests is required")
    private Integer numberOfGuests;

    private Long restaurantTableId;
    private Long restaurantId;
}
