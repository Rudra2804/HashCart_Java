package com.deloitte.hashcart.cartservice.controller;

import com.deloitte.hashcart.cartservice.exception.ProductNotPresentInCart;
import com.deloitte.hashcart.cartservice.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;

import java.time.LocalDateTime;
import java.util.Arrays;

public class ExceptionController {

    @ExceptionHandler(ProductNotPresentInCart.class)
    public ResponseEntity<?> productNotFoundException(Exception e, ServletWebRequest request){
        ApiError error = new ApiError();
        error.setTime(LocalDateTime.now());
        error.setPathUri(request.getDescription(true));
        error.setStatus(HttpStatus.BAD_REQUEST);
        error.setErrors(Arrays.asList(e.getClass()+" : "+e.getMessage()));
        return new ResponseEntity<>(error,error.getStatus());
    }
}
