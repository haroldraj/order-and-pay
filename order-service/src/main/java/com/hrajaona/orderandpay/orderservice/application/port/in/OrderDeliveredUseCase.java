package com.hrajaona.orderandpay.orderservice.application.port.in;

import com.hrajaona.library.events.OrderDeliveredEvent;

public interface OrderDeliveredUseCase {
    void handle(OrderDeliveredEvent orderDeliveredEvent, String correlationId);
}
