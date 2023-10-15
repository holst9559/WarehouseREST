package com.example.warehouserest.interceptor;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
@Log
public class LoggingInterceptor {

    Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);

    @AroundInvoke
    public Object logMethodEntry(InvocationContext context) throws Exception{
        var methodName = context.getMethod().getName();
        var className = context.getMethod().getDeclaringClass().getSimpleName();
        var inputParameters = Arrays.toString(context.getParameters());
        logger.info("Call to method: " + methodName + " in " + className + ". With parameters: " + inputParameters);

        return context.proceed();
    }
}
