package com.deloitte.hashcart.cartservice.controller;

import com.deloitte.hashcart.cartservice.exception.UserNotFoundException;
import com.deloitte.hashcart.cartservice.feign.ProductFeign;
import com.deloitte.hashcart.cartservice.feign.UserFeign;
import com.deloitte.hashcart.cartservice.model.Cart;
import com.deloitte.hashcart.cartservice.model.Product;
import com.deloitte.hashcart.cartservice.model.User;
import com.deloitte.hashcart.cartservice.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cart")
@Slf4j
public class CartController {

    @Autowired
    private CartService service;

    @Autowired
    private UserFeign feign;

    @Autowired
    private ProductFeign productFeign;

    @PostMapping("/addProduct")
    public ResponseEntity<Cart> addProductToCart(@RequestBody Cart cart) throws UserNotFoundException {
        log.info("Inside Add Product to cart");
        Cart c = service.addProductToCart(cart);
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }

    @DeleteMapping("/removeProduct")
    public ResponseEntity<Cart> removeProductToCart(@RequestBody Cart cart) {
        log.info("Inside remove product from cart");
        Cart c = service.removeProductFromCart(cart);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCart/{id}")
    public ResponseEntity<Cart> deleteCart(@PathVariable("id") Integer id) {
        log.info("Inside delete cart");
        Cart c = service.deleteCart(id);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @GetMapping("/getUserDetailsByCartId/{id}")
    public ResponseEntity<User> getUserDetailsByCartId(@PathVariable("id") Integer id) throws UserNotFoundException {
        log.info("Inside getUserDetailsByCartId()");

        Cart cart=service.findCartById(id);
        ResponseEntity<User> user = feign.getUserById(cart.getU_id());

        System.out.println("User Details =" + user.getBody().getFirstname() + "=" + user.getBody().getLastname());
            return user;
    }

    @GetMapping("/getProductDetailsByCartId/{id}")
    public ResponseEntity<Product> getProductDetailsByCartId(@PathVariable("id") Integer id) throws UserNotFoundException {
        log.info("Inside getProductDetailsByCartId()");

        Cart cart=service.findCartById(id);
        ResponseEntity<Product> product = productFeign.getProductById(cart.getP_id());

        System.out.println("User Details =" + product.getBody().getName() + "=" + product.getBody().getDescription());
        return product;
    }

}
