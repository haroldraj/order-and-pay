package com.hrajaona.orderandpay.restaurantservice.application.port.out;

import com.hrajaona.library.events.OrderReadyForDelivery;

public interface OrderEventProducer {
    void publishOrderReadyForDelivery(OrderReadyForDelivery orderReadyForDelivery, String correlationId);
}
