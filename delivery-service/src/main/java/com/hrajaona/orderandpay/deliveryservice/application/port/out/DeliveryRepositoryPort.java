package com.hrajaona.orderandpay.deliveryservice.application.port.out;

import com.hrajaona.orderandpay.deliveryservice.domain.model.Delivery;

public interface DeliveryRepositoryPort {
    Delivery save(Delivery delivery);
}
