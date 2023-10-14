package com.example.warehouserest.service;


import com.example.warehouserest.entities.Category;
import com.example.warehouserest.entities.Product;
import com.example.warehouserest.entities.ProductRecord;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import static com.example.warehouserest.entities.Category.MALT;


@ApplicationScoped
public class Warehouse implements WarehouseService{

    private final List<Product> products = new CopyOnWriteArrayList<>();
    private final int maxRating = 5;




    public ProductRecord addNewProduct(@Valid ProductRecord product) {
        if (product.name() == null || product.name().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else if (product.rating() > maxRating || product.rating() < 0) {
            throw new IllegalArgumentException("Rating cannot be higher than 5");
        }

        Product newProduct = new Product(product);
        products.add(newProduct);


        return newProduct.toRecord();
    }

    public ProductRecord updateProduct(@Valid ProductRecord productUpdate) {
        return products.stream().filter(product -> product.getId().equals(productUpdate.id())).findFirst()
                .map(product -> {
                    product.setName(productUpdate.name());
                    product.setCategory(productUpdate.category());
                    product.setRating(productUpdate.rating());
                    product.setUpdatedAt(LocalDate.now());
                    return product.toRecord();
                }).orElseThrow(() -> new IllegalArgumentException("Product ID does not exist"));
    }


    public List<ProductRecord> getAllProducts() {
        Product testProduct = new Product("Malt", MALT, 2, LocalDate.now(), LocalDate.now());
        products.add(testProduct);
        return products.stream()
                .map(Product::toRecord)
                .toList();
    }

    public ProductRecord getProductById(String productId) {
        return products.stream().filter(product -> product.getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Product ID does not exist"))
                .toRecord();
    }

    public List<ProductRecord> getProductsByCategory(Category category) {
        return products.stream().filter(product -> product.getCategory().equals(category))
                .sorted(Comparator.comparing(Product::getName))
                .map(Product::toRecord)
                .toList();
    }

    public List<ProductRecord> getProductsAfterDate(LocalDate localDate) {
        return products.stream().filter(product -> product.getCreatedAt().isAfter(localDate))
                .map(Product::toRecord)
                .toList();
    }

    public List<ProductRecord> getUpdatedProducts() {
        return products.stream().filter(product -> !product.getUpdatedAt().equals(product.getCreatedAt()))
                .map(Product::toRecord)
                .toList();
    }

    public Set<Category> getPopulatedCategories() {
        return products.stream().map(Product::getCategory)
                .collect(Collectors.toUnmodifiableSet());

    }

    public int getNumberOfProductsInCategory(Category category) {
        return products.stream().map(Product::getCategory)
                .filter(productCategory -> productCategory.equals(category))
                .toList()
                .size();
    }

    public Map<Character, Long> getProductMap() {
        return products.stream().collect(Collectors.groupingBy(product -> product.getName().charAt(0),
                Collectors.counting()));
    }

    public List<ProductRecord> getMaxRatingLastMonth() {
        return products.stream().filter(product -> product.getCreatedAt()
                        .isAfter(LocalDate.now().minusMonths(1)))
                .filter(product -> product.getRating() == maxRating)
                .sorted(Comparator.comparing(Product::getCreatedAt).reversed())
                .map(Product::toRecord)
                .toList();
    }
}
