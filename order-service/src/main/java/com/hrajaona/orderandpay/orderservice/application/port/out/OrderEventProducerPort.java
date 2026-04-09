package com.hrajaona.orderandpay.orderservice.application.port.out;


import com.hrajaona.library.events.OrderCreatedEvent;
import com.hrajaona.orderandpay.orderservice.domain.model.Order;

public interface OrderEventProducerPort {
    void publishOrderCreated(OrderCreatedEvent orderCreatedEvent, String correlationId);
    void publishOrderPaid(Order order, String correlationId);
}
