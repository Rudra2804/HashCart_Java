package com.deloitte.hashcart.paymentservice.service;

import com.deloitte.hashcart.paymentservice.model.Order_info;
import com.deloitte.hashcart.paymentservice.model.Payment;
import com.deloitte.hashcart.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository repository;

    public Order_info makePayment(Order_info order){
        Payment p=new Payment();
        p.setAmount(order.getTotal());
        p.setStatus("Success");
        p.setTransactionId(UUID.randomUUID().toString());
        Payment pay=repository.save(p);
        order.setPayment_id(pay.getId());
        return order;
    }
}
