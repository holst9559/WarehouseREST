package com.example.warehouserest.entities;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public record ProductRecord(String id,
                            @NotEmpty(message = "Name cannot be empty")
                            String name,
                            Category category,
                            @Min(value = 0, message = "Rating cannot be less than 0")
                            @Max(value = 5, message = "Rating cannot be higher than 5")
                            int rating,
                            LocalDate createdAt,
                            LocalDate updatedAt) {

}
