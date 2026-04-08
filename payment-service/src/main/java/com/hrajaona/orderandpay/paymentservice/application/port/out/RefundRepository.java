package com.hrajaona.orderandpay.paymentservice.application.port.out;

import com.hrajaona.orderandpay.paymentservice.adapters.out.persistence.entity.RefundJpaEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RefundRepository {
    List<RefundJpaEntity> findAll();
    Optional<RefundJpaEntity> findById(UUID id);
}
