package com.example.orderservice.service;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.entity.Order;
import com.example.orderservice.repository.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public OrderDto createOrder(OrderDto orderDetails) {
        orderDetails.setOrderId(UUID.randomUUID().toString());
        orderDetails.setTotalPrice(orderDetails.getQty() * orderDetails.getUnitPrice());

        ObjectMapper mapper = new ObjectMapper();
        Order order = mapper.convertValue(orderDetails, Order.class);
        orderRepository.save(order);

        return mapper.convertValue(order, OrderDto.class);
    }

    @Override
    public OrderDto getOrderByOrderId(String orderId) {
        Order order = orderRepository.findByOrderId(orderId);
        return new ObjectMapper().convertValue(order, OrderDto.class);
    }

    @Override
    public Iterable<Order> getOrdersByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }
}
