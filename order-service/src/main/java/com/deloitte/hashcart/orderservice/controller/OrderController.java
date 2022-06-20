package com.deloitte.hashcart.orderservice.controller;

import com.deloitte.hashcart.orderservice.feign.PaymentFeign;
import com.deloitte.hashcart.orderservice.model.Order_info;
import com.deloitte.hashcart.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @Autowired
    private PaymentFeign paymentFeign;

    @PostMapping("/placeOrder")
    public ResponseEntity<Order_info> doOrder(@RequestBody Order_info order){
        log.info("Inside Place Order Method");
        Order_info o=service.doOrder(order);
        log.info("Order is saved and making Payment now");
        ResponseEntity<Order_info> orderResponseEntity=paymentFeign.makePayment(o);
        log.info("Payment is done !! Success !!");
        return orderResponseEntity;
    }
}
