package com.deloitte.hashcart.productservice.controller;

import com.deloitte.hashcart.productservice.exception.ProductNotFoundException;
import com.deloitte.hashcart.productservice.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;

import java.time.LocalDateTime;
import java.util.Arrays;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> productNotFoundException(Exception e, ServletWebRequest request){
        ApiError error = new ApiError();
        error.setTime(LocalDateTime.now());
        error.setPathUri(request.getDescription(true));
        error.setStatus(HttpStatus.BAD_REQUEST);
        error.setErrors(Arrays.asList(e.getClass()+" : "+e.getMessage()));
        return new ResponseEntity<>(error,error.getStatus());
    }
}
