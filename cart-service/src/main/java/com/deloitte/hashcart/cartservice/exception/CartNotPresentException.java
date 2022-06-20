package com.deloitte.hashcart.cartservice.exception;

public class CartNotPresentException extends RuntimeException {
    public CartNotPresentException(String s) {
        super(s);
    }
}
