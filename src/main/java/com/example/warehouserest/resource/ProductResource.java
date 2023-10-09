package com.example.warehouserest.resource;

import com.example.warehouserest.entities.ProductRecord;
import com.example.warehouserest.service.WarehouseService;
import jakarta.inject.Inject;
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
    public Response addNewProduct(ProductRecord product){
        warehouseService.addNewProduct(product);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{id}")
    public ProductRecord getProductById(@PathParam("id") String id){
        return warehouseService.getProductById(id);
    }

    @PATCH
    @Path("/{id}")
    public Response updateProduct(@PathParam("id") String id, ProductRecord productUpdate){
        warehouseService.updateProduct(id, productUpdate);
        return Response.ok().build();
    }

}
