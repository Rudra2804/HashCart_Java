package com.deloitte.hashcart.orderservice.feign;

import com.deloitte.hashcart.orderservice.model.Order_info;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("PAYMENT-SERVICE")
public interface PaymentFeign {

    @PostMapping("/payment/makePayment")
    public ResponseEntity<Order_info> makePayment(@RequestBody Order_info order) ;

}
