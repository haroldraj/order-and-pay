package com.hrajaona.orderandpay.deliveryservice.adapters;

import com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.repository.DeliveryAssignmentJpaRepository;
import com.hrajaona.orderandpay.deliveryservice.application.port.out.DeliveryAssignmentRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeliveryAssignmentPersistenceAdapter implements DeliveryAssignmentRepositoryPort {
    private final DeliveryAssignmentJpaRepository deliveryAssignmentJpaRepository;
}
