package com.hrajaona.orderandpay.orderservice.application.port.out;

import com.hrajaona.orderandpay.orderservice.domain.model.Order;
import com.hrajaona.orderandpay.orderservice.domain.model.OrderItem;
import org.springframework.stereotype.Component;

import java.util.List;

public interface OrderRepository {
    List<Order> findAll();
    Order save(Order order, List<OrderItem> orderItems);
}
