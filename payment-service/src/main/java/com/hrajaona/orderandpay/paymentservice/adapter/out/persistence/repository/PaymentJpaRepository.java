package com.hrajaona.orderandpay.paymentservice.adapter.out.persistence.repository;

import com.hrajaona.orderandpay.paymentservice.adapter.out.persistence.entity.PaymentJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentJpaRepository extends JpaRepository<PaymentJpaEntity, Long> {
}
