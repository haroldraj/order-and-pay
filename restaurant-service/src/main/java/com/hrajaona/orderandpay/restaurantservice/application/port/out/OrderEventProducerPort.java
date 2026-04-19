package com.hrajaona.orderandpay.restaurantservice.application.port.out;

import com.hrajaona.library.events.OrderPreparingEvent;
import com.hrajaona.library.events.OrderReadyForDeliveryEvent;

public interface OrderEventProducerPort {
    void publishOrderReadyForDelivery(OrderReadyForDeliveryEvent orderReadyForDeliveryEvent, String correlationId);
    void publishOrderPreparing(OrderPreparingEvent orderPreparingEvent, String correlationId);
}
