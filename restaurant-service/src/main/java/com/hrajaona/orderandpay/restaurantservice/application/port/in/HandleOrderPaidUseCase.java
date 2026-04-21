package com.hrajaona.orderandpay.restaurantservice.application.port.in;

import com.hrajaona.library.events.OrderPaidEvent;

public interface HandleOrderPaidUseCase {
    void handle(OrderPaidEvent event, String correlationId);
}
