package com.hrajaona.orderandpay.orderservice.application.port.in;

import com.hrajaona.orderandpay.orderservice.adapters.in.web.dto.OrderRequest;
import com.hrajaona.orderandpay.orderservice.domain.model.Order;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface OrderUseCase {
    List<Order> getAllOrders();
    Order create(OrderRequest orderRequest, String correlationId);
    void processOrderPayment(Order order, String correlationId);
    Order getOrderByIdAndUserIdAndAmount(UUID id, UUID userId, BigDecimal amount);
}
