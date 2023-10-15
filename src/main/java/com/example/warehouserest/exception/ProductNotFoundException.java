package com.example.warehouserest.exception;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class ProductNotFoundException extends WebApplicationException {
    public ProductNotFoundException(){
        super("Product ID not found", Response.Status.NOT_FOUND);
    }
}
