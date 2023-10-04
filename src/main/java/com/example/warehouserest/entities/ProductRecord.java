package com.example.warehouserest.entities;

import java.time.LocalDate;

public record ProductRecord(String id, String name, Category category, int rating, LocalDate createdAt,
                            LocalDate updatedAt) {

}
