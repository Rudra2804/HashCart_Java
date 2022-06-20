package com.deloitte.hashcart.productservice.service;

import com.deloitte.hashcart.productservice.exception.ProductNotFoundException;
import com.deloitte.hashcart.productservice.model.Product;
import com.deloitte.hashcart.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;


    public Product saveProduct(Product u) throws ProductNotFoundException {
        Product t = repository.save(u);
        if (t != null) {
            return t;
        } else {
            throw new ProductNotFoundException("Product Not Found");
        }
    }


    public Product getProductById(Integer id) throws ProductNotFoundException {
        Optional<Product> Product = repository.findById(id);
        if (Product.isPresent()) {
            return Product.get();
        } else {
            throw new ProductNotFoundException("Product not found with given Id");
        }
    }

    public List<Product> getAllProduct() {
        return repository.findAll();
    }

    public Product deleteProductById(Integer id) throws ProductNotFoundException {
        Optional<Product> Product = repository.findById(id);
        if (Product .isPresent()) {
            repository.delete(Product.get());
            return Product.get();
        } else {
            throw new ProductNotFoundException("Product not found with given Id");
        }

    }

    public Product updateProductById(Integer id, Product Product) throws ProductNotFoundException {
        Optional<Product> u = repository.findById(id);
        if (u.isPresent()) {
            u.get().setName(Product.getName());
            u.get().setDescription(Product.getDescription());
            u.get().setPrice(Product.getPrice());
            u.get().setDiscount(Product.getDiscount());
            u.get().setDiscountInfo(Product.getDiscountInfo());
            repository.save(u.get());
            return u.get();
        } else {
            throw new ProductNotFoundException("Product not found with given Id");
        }
    }
}
