package com.example.warehouserest.resource;

import com.example.warehouserest.entities.ProductRecord;
import com.example.warehouserest.interceptor.Log;
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
@Log
public class ProductResource {
    private WarehouseService warehouseService;

    public ProductResource(){}

    @Inject
    public ProductResource(WarehouseService warehouseService){
        this.warehouseService = warehouseService;
    }

    @GET
    public Response getAllProducts(){
        return Response.ok(warehouseService.getAllProducts()).build();
    }

    @POST
    public Response addNewProduct(@Valid ProductRecord product){
        warehouseService.addNewProduct(product);
        return Response.status(Response.Status.CREATED)
                .entity(warehouseService.addNewProduct((product))).build();
    }

    @GET
    @Path("/{id}")
    public Response getProductById(@PathParam("id") String id){
        return Response.ok(warehouseService.getProductById(id)).build();
    }

    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProduct(@Valid ProductRecord productUpdate){
        return Response.ok(warehouseService.updateProduct(productUpdate)).build();
    }

}
