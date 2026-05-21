package com.example.RestaurantTableBooking.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RestaurantTableDTO {

    @NotNull(message = "Assign Table Number")
    private Integer tableNumber;
    @NotNull(message = "Mention Table Capacity")
    private Integer capacity;

    private Long restaurantId;
}
