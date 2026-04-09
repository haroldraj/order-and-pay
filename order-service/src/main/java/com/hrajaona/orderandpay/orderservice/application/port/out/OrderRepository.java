package com.hrajaona.orderandpay.orderservice.application.port.out;

import com.hrajaona.orderandpay.orderservice.domain.model.Order;
import com.hrajaona.orderandpay.orderservice.domain.model.OrderItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {
    List<Order> findAll();
    Order save(Order order, List<OrderItem> orderItems);
    Order findByIdAndUserIdAndAmount(UUID id, UUID userId, BigDecimal amount);
}
