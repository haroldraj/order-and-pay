package com.hrajaona.orderandpay.orderservice.application.port.out;


import com.hrajaona.library.events.OrderCreatedEvent;
import com.hrajaona.library.events.OrderPaidEvent;

public interface OrderEventProducerPort {
    void publishOrderCreated(OrderCreatedEvent orderCreatedEvent, String correlationId);
    void publishOrderPaid(OrderPaidEvent event, String correlationId);
}
