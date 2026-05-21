package com.example.RestaurantTableBooking.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="restaurants")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "restaurantName")
    @NotBlank(message = "restaurant name is required")
    private String name;

    @Column(name = "restaurantAddress")
    @NotBlank(message = "restaurant address is required")
    private String address;

    @Column(name="Manager_Contact")
    @NotBlank(message = "Manager number is required")
    private String phoneNumber;

    @Column(name="TableCount")
    @NotNull(message = "Mention number of tables")
    @Min(value=4,message = "minimum 4 tables is required")
    private Integer totalTables;
}
