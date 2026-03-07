package com.hrajaona.orderandpay.orderservice.application.port.out;

import com.hrajaona.orderandpay.orderservice.domain.model.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderRepository {
    List<Order> findAll();
    Order save(Order order);
}
