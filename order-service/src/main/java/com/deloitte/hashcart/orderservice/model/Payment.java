package com.deloitte.hashcart.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private Integer id;
    private String status;
    private String transactionId;
    private Long amount;

}
