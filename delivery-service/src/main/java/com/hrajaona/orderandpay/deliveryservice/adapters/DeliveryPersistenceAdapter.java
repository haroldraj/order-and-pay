package com.hrajaona.orderandpay.deliveryservice.adapters;

import com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.repository.DeliveryJpaRepository;
import com.hrajaona.orderandpay.deliveryservice.application.port.out.DeliveryRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeliveryPersistenceAdapter implements DeliveryRepositoryPort {
    private final DeliveryJpaRepository deliveryJpaRepository;
}
