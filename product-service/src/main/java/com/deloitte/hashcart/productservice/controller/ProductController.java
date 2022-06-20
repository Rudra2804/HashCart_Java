package com.deloitte.hashcart.productservice.controller;

import com.deloitte.hashcart.productservice.exception.ProductNotFoundException;
import com.deloitte.hashcart.productservice.model.Product;
import com.deloitte.hashcart.productservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;


    @PostMapping("/addProduct")
    public ResponseEntity<Product> addNewProduct(@RequestBody Product Product) throws ProductNotFoundException {
        log.info("adding new  Product "+Product.getName());
        Product Product1 = service.saveProduct(Product);
        return new ResponseEntity<Product>(Product1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id) throws ProductNotFoundException {
        log.info("Inside Get Product by Id() ");
        Product u=service.getProductById(id);
        return new ResponseEntity<>(u,HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Product>> getAllProduct(){
        log.info("Inside Get All Product Information ");
        List<Product> list=service.getAllProduct();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable("id") Integer id) throws ProductNotFoundException {
        log.info("Inside Delete Product by Id() ");
        Product u=service.deleteProductById(id);
        return new ResponseEntity<>(u,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProductById(@PathVariable("id") Integer id,@RequestBody Product Product) throws ProductNotFoundException {
        log.info("Inside Delete Product by Id() ");
        Product u=service.updateProductById(id,Product);
        return new ResponseEntity<>(u,HttpStatus.OK);
    }
}
