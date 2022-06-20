package com.deloitte.hashcart.cartservice.feign;

import com.deloitte.hashcart.cartservice.exception.ProductNotFoundException;
import com.deloitte.hashcart.cartservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="PRODUCT-SERVICE")
public interface ProductFeign {

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id) throws ProductNotFoundException;
}
