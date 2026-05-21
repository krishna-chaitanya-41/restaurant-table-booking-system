package com.example.RestaurantTableBooking.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="RestaurantTables")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RestaurantTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "table number is required")
    @Column(name="Table_Number")
    @Positive
    private Integer tableNumber;

    @NotNull(message = "capacity of the table is required")
    @Column(name="TableCapacity")
    @Min(value = 1,message = "Capacity should be at least 1")
    private Integer capacity;

    @Column(name="TableAvailability")
    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;
}
