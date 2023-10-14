package com.example.warehouserest.resource;

import com.example.warehouserest.entities.ProductRecord;
import com.example.warehouserest.service.WarehouseService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {
    private WarehouseService warehouseService;

    public ProductResource(){}

    @Inject
    public ProductResource(WarehouseService warehouseService){
        this.warehouseService = warehouseService;
    }

    @GET
    public List<ProductRecord> getAllProducts(){
        return warehouseService.getAllProducts();
    }

    @POST
    public Response addNewProduct(@Valid ProductRecord product){
        warehouseService.addNewProduct(product);
        return Response.status(201).entity(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{id}")
    public ProductRecord getProductById(@PathParam("id") String id){
        return warehouseService.getProductById(id);
    }

    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProduct(@Valid ProductRecord productUpdate){
        warehouseService.updateProduct(productUpdate);
        return Response.ok().build();
    }

}
