package com.deloitte.hashcart.paymentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order_info {
    private Integer id;

    private Integer user_id;
    private Integer product_id;
    private Long total;
    private Integer payment_id;
}
