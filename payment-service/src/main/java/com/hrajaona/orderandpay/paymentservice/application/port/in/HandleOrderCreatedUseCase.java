package com.hrajaona.orderandpay.paymentservice.application.port.in;

import com.hrajaona.library.events.OrderCreatedEvent;

public interface HandleOrderCreatedUseCase {
    void handle(OrderCreatedEvent event, String correlationId);
}
