package com.hrajaona.orderandpay.orderservice.application.port.out;

import com.hrajaona.orderandpay.orderservice.domain.model.Order;
import com.hrajaona.orderandpay.orderservice.domain.model.OrderItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface OrderRepositoryPort {
    List<Order> findAll();
    Order findByIdAndUserId(UUID id, UUID userId);
    Order update(Order order, List<OrderItem> orderItems);
    Order findByIdAndUserIdAndAmount(UUID id, UUID userId, BigDecimal amount);
//    void update(Order order);
    void update(Order order);
}
