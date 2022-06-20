package com.deloitte.hashcart.orderservice.repository;

import com.deloitte.hashcart.orderservice.model.Order_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order_info,Integer> {

}
