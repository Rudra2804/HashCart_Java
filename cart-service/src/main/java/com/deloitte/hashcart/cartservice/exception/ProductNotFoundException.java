package com.deloitte.hashcart.cartservice.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String product_not_found) {
        super(product_not_found);
    }
}
