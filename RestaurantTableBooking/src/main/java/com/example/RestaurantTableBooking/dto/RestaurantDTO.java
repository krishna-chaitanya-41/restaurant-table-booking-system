package com.example.RestaurantTableBooking.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RestaurantDTO {

    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message = "address is required")
    private String address;
    @NotBlank(message = "Phone Number is required")
    private String PhoneNumber;
    @NotNull(message = "Mention number of tables")
    private Integer totalTables;
}
