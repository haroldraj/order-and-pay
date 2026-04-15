package com.hrajaona.orderandpay.deliveryservice.application.port.in;

import com.hrajaona.library.events.OrderPaidEvent;
import com.hrajaona.library.events.OrderReadyForDelivery;

public interface HandleOrderReadyUseCase {
    void handle(OrderReadyForDelivery order, String correlationId);
}
