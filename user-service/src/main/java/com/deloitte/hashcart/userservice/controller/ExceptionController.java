package com.deloitte.hashcart.userservice.controller;

import com.deloitte.hashcart.userservice.exception.UserNotFoundException;
import com.deloitte.hashcart.userservice.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;

import java.time.LocalDateTime;
import java.util.Arrays;

@ControllerAdvice
public class ExceptionController extends Exception{

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<?> userNotFoundException(Exception e, ServletWebRequest request){

        ApiError error = new ApiError();
        error.setTime(LocalDateTime.now());
        error.setPathUri(request.getDescription(true));
        error.setStatus(HttpStatus.BAD_REQUEST);
        error.setErrors(Arrays.asList(e.getClass()+" : "+e.getMessage()));
        return new ResponseEntity<>(error,error.getStatus());
    }
}
