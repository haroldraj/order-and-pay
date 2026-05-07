package com.hrajaona.orderandpay.orderservice.application.port.in;

import com.hrajaona.library.events.OrderPickedUpEvent;

public interface OrderPickedUpUseCase {
    void handle(OrderPickedUpEvent orderPickedUpEvent, String correlationId);
}
