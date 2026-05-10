package com.hrajaona.orderandpay.deliveryservice.adapters;

import com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.entity.DeliveryJpaEntity;
import com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.mapper.DeliveryPersistenceMapper;
import com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.repository.DeliveryJpaRepository;
import com.hrajaona.orderandpay.deliveryservice.application.port.out.DeliveryRepositoryPort;
import com.hrajaona.orderandpay.deliveryservice.domain.model.Delivery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class DeliveryPersistenceAdapter implements DeliveryRepositoryPort {
    private final DeliveryJpaRepository deliveryJpaRepository;
    private final DeliveryPersistenceMapper deliveryPersistenceMapper;

    @Override
    public Delivery save(Delivery delivery) {

        try {
            delivery.setId(UUID.randomUUID());
            DeliveryJpaEntity deliveryJpa = deliveryPersistenceMapper.toEntity(delivery);

            return deliveryPersistenceMapper.toDomain(deliveryJpaRepository.save(deliveryJpa));
        } catch (Exception e) {
            throw new RuntimeException("Failed to save delivery", e);
        }
    }
}
