package com.example.warehouserest.exception;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyExceptionMapper implements ExceptionMapper<WebApplicationException> {
    private static final Logger logger = LoggerFactory.getLogger(MyExceptionMapper.class);

    @Override
    public Response toResponse(WebApplicationException e)
    {
        return Response.status(e.getResponse().getStatus()).entity(e.getMessage()).build();
    }
}
