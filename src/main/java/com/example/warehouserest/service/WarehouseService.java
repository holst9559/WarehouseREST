package com.example.warehouserest.service;

import com.example.warehouserest.entities.Category;
import com.example.warehouserest.entities.ProductRecord;
import jakarta.ejb.ConcurrencyManagement;
import jakarta.ejb.ConcurrencyManagementType;
import jakarta.ejb.Lock;
import jakarta.ejb.LockType;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public interface WarehouseService {

    ProductRecord addNewProduct(ProductRecord product);
    ProductRecord updateProduct(ProductRecord productUpdate);
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
