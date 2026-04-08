package com.hrajaona.orderandpay.paymentservice.adapters.out.persistence.repository;

import com.hrajaona.orderandpay.paymentservice.adapters.out.persistence.entity.RefundJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RefundJpaRepository extends JpaRepository<RefundJpaEntity, UUID> {
}
