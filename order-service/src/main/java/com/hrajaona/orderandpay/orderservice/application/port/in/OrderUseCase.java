package com.hrajaona.orderandpay.orderservice.application.port.in;

import com.hrajaona.orderandpay.orderservice.adapters.in.web.dto.OrderRequest;
import com.hrajaona.orderandpay.orderservice.domain.model.Order;

import java.util.List;

public interface OrderUseCase {
    String createOrder(OrderRequest orderRequest);
    List<Order> getAllOrders();
}
