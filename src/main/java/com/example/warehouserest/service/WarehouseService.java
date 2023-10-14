package com.example.warehouserest.service;

import com.example.warehouserest.entities.Category;
import com.example.warehouserest.entities.ProductRecord;
import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
public interface WarehouseService {

    ProductRecord addNewProduct(@Valid ProductRecord product);
    ProductRecord updateProduct(@Valid ProductRecord productUpdate);
    List<ProductRecord> getAllProducts();
    ProductRecord getProductById(String productId);
    List<ProductRecord> getProductsByCategory(Category category);
    List<ProductRecord> getProductsAfterDate(LocalDate localDate);
    List<ProductRecord> getUpdatedProducts();
    Set<Category> getPopulatedCategories();
    int getNumberOfProductsInCategory(Category category);
    Map<Character, Long> getProductMap();
    List<ProductRecord> getMaxRatingLastMonth();
}
