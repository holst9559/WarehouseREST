package com.example.warehouserest.resource;

import com.example.warehouserest.entities.Category;
import com.example.warehouserest.entities.ProductRecord;
import com.example.warehouserest.interceptor.Log;
import com.example.warehouserest.service.WarehouseService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Set;

@Path("/category")
@Produces(MediaType.APPLICATION_JSON)
@Log
public class CategoryResource {
    private WarehouseService warehouseService;

    public CategoryResource(){}

    @Inject
    public CategoryResource(WarehouseService warehouseService){
        this.warehouseService = warehouseService;
    }
    @GET
    public Response getPopulatedCategories(){
        return Response.ok(warehouseService.getPopulatedCategories()).build();
    }

    @GET
    @Path("/{category}")
    public Response getProductsByCategory(@PathParam("category") Category category){
        return Response.ok(warehouseService.getProductsByCategory(category)).build();
    }
}

