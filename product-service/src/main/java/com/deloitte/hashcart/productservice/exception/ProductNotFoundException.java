package com.deloitte.hashcart.productservice.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String product_not_found) {
        super(product_not_found);
    }
}
