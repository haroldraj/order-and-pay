package com.hrajaona.orderandpay.orderservice.application.port.out;


import com.hrajaona.library.events.OrderCreatedEvent;

public interface OrderEventProducerPort {
    void publishOrderCreated(OrderCreatedEvent orderCreatedEvent, String correlationId);
}
