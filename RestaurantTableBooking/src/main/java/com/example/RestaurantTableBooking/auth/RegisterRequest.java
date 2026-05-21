package com.example.RestaurantTableBooking.auth;

import com.example.RestaurantTableBooking.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private Status role;
}
