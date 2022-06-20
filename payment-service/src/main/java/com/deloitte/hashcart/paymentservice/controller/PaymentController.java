package com.deloitte.hashcart.paymentservice.controller;

import com.deloitte.hashcart.paymentservice.model.Order_info;
import com.deloitte.hashcart.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping("/makePayment")
    public ResponseEntity<Order_info> makePayment(@RequestBody Order_info order) {
        Order_info r = service.makePayment(order);
        return new ResponseEntity<>(r, HttpStatus.OK);
    }
}
