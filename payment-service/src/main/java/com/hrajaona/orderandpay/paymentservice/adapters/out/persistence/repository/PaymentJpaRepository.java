package com.hrajaona.orderandpay.paymentservice.adapters.out.persistence.repository;

import com.hrajaona.orderandpay.paymentservice.adapters.out.persistence.entity.PaymentJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PaymentJpaRepository extends JpaRepository<PaymentJpaEntity, UUID> {

    Optional<PaymentJpaEntity> findByOrderIdAndUserId(UUID orderId, UUID userId);
}
