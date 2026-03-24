package com.hrajaona.orderandpay.orderservice.application.port.out;


import com.hrajaona.orderandpay.orderservice.domain.event.OrderCreatedEvent;

public interface OrderEventProducerPort {
    void publishOrderCreated(OrderCreatedEvent orderCreatedEvent);
}
