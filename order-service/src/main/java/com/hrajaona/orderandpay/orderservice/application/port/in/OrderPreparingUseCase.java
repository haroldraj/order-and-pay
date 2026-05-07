package com.hrajaona.orderandpay.orderservice.application.port.in;

import com.hrajaona.library.events.OrderPreparingEvent;

public interface OrderPreparingUseCase {
    void handle(OrderPreparingEvent orderPreparingEvent, String correlationId);
}
