package com.hrajaona.orderandpay.deliveryservice.application.port.in;

import com.hrajaona.library.events.OrderReadyForDeliveryEvent;

public interface HandleOrderReadyUseCase {
    void handle(OrderReadyForDeliveryEvent order, String correlationId);
}
