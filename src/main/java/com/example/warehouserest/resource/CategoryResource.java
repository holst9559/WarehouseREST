package com.example.warehouserest.resource;

import com.example.warehouserest.entities.Category;
import com.example.warehouserest.entities.ProductRecord;
import com.example.warehouserest.service.WarehouseService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Set;

@Path("/category")
@Produces(MediaType.APPLICATION_JSON)
public class CategoryResource {
    private WarehouseService warehouseService;

    public CategoryResource(){}

    @Inject
    public CategoryResource(WarehouseService warehouseService){
        this.warehouseService = warehouseService;
    }
    @GET
    public Set<Category> getPopulatedCategories(){
        return warehouseService.getPopulatedCategories();
    }

    @GET
    @Path("/{category}")
    public List<ProductRecord> getProductsByCategory(@PathParam("category") Category category){
        return warehouseService.getProductsByCategory(category);
    }
}

