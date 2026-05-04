package com.hrajaona.orderandpay.deliveryservice.application.handler;

import com.hrajaona.library.events.OrderReadyForDeliveryEvent;
import com.hrajaona.orderandpay.deliveryservice.application.port.in.HandleOrderReadyUseCase;

public class OrderReadyForDeliveryHandler implements HandleOrderReadyUseCase {
    @Override
    public void handle(OrderReadyForDeliveryEvent order, String correlationId) {

    }
}
