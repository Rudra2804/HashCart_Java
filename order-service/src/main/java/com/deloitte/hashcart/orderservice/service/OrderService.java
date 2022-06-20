package com.deloitte.hashcart.orderservice.service;

import com.deloitte.hashcart.orderservice.model.Order_info;
import com.deloitte.hashcart.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public Order_info doOrder(Order_info o) {
        return repository.save(o);
    }
}
