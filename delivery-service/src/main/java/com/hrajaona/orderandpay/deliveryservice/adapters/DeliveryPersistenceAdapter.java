package com.hrajaona.orderandpay.deliveryservice.adapters;

import com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.entity.DeliveryJpaEntity;
import com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.mapper.DeliveryPersistenceMapper;
import com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.repository.DeliveryJpaRepository;
import com.hrajaona.orderandpay.deliveryservice.application.port.out.DeliveryRepositoryPort;
import com.hrajaona.orderandpay.deliveryservice.domain.model.Delivery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeliveryPersistenceAdapter implements DeliveryRepositoryPort {
    private final DeliveryJpaRepository deliveryJpaRepository;
    private final DeliveryPersistenceMapper deliveryPersistenceMapper;

    @Override
    public void save(Delivery delivery) {
        DeliveryJpaEntity deliveryJpa = deliveryPersistenceMapper.toEntity(delivery);

        deliveryJpaRepository.save(deliveryJpa);
    }
}
