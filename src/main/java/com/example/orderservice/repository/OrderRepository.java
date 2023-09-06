package com.example.orderservice.repository;

import com.example.orderservice.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
    Order findByOrderId(String orderId);
    Iterable<Order> findByUserId(String userId);
}
