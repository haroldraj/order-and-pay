package com.hrajaona.orderandpay.deliveryservice.adapters;

import com.hrajaona.library.enums.DeliveryStatus;
import com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.entity.DeliveryAssignmentJpaEntity;
import com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.repository.DeliveryAssignmentJpaRepository;
import com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.repository.DeliveryJpaRepository;
import com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.repository.DriverJpaRepository;
import com.hrajaona.orderandpay.deliveryservice.application.port.out.DeliveryAssignmentRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DeliveryAssignmentPersistenceAdapter implements DeliveryAssignmentRepositoryPort {
    private final DeliveryAssignmentJpaRepository deliveryAssignmentJpaRepository;
    private final DriverJpaRepository driverJpaRepository;
    private final DeliveryJpaRepository deliveryJpaRepository;

    @Override
    public void assignDriverToDelivery(UUID driverId, UUID deliveryId) {
        DeliveryAssignmentJpaEntity deliveryAssignmentJpa = new DeliveryAssignmentJpaEntity();

        deliveryAssignmentJpa.setDriver(driverJpaRepository.getReferenceById(driverId));
        deliveryAssignmentJpa.setDelivery(deliveryJpaRepository.getReferenceById(deliveryId));
        deliveryAssignmentJpa.setStatus(DeliveryStatus.ASSIGNED.toString());
        deliveryAssignmentJpa.setAssignedAt(LocalDateTime.now());

        deliveryAssignmentJpaRepository.save(deliveryAssignmentJpa);
    }
}
