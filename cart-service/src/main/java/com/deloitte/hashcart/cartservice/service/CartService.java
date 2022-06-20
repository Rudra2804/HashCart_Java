package com.deloitte.hashcart.cartservice.service;

import com.deloitte.hashcart.cartservice.exception.CartNotPresentException;
import com.deloitte.hashcart.cartservice.exception.ProductNotPresentInCart;
import com.deloitte.hashcart.cartservice.model.Cart;
import com.deloitte.hashcart.cartservice.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository repository;

    public Cart addProductToCart(Cart c) {
        Cart cart = repository.save(c);
        return cart;
    }


    public Cart removeProductFromCart(Cart cart) {
        Optional<Cart> c=repository.findById(cart.getId());
        if(c.isPresent()){
            c.get().setP_id(null);
            c.get().setQuantity(null);
          Cart cc=  repository.save(c.get());
        return cc;
        }
        else{
            throw new ProductNotPresentInCart("Product is not present in cart");
        }
    }

    public Cart deleteCart(Integer id) {
        Optional<Cart> c=repository.findById(id);
        if(c.isPresent()){
            repository.delete(c.get());
            return c.get();
        }
        else{
            throw new CartNotPresentException("Cart is not present with given id");
        }
    }

    public Cart findCartById(Integer id) {
        Optional<Cart> c=repository.findById(id);
        if(c.isPresent()){
            return c.get();
        }
        else{
            throw new CartNotPresentException("Cart is not present with given id");
        }
    }
}
