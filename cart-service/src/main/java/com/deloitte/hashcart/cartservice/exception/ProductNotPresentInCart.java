package com.deloitte.hashcart.cartservice.exception;

import com.deloitte.hashcart.cartservice.model.Product;

public class ProductNotPresentInCart extends RuntimeException {

    public ProductNotPresentInCart(String s){
        super(s);
    }
}
