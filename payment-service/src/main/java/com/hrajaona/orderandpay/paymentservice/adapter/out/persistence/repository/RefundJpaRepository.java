package com.hrajaona.orderandpay.paymentservice.adapter.out.persistence.repository;

import com.hrajaona.orderandpay.paymentservice.adapter.out.persistence.entity.RefundJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RefundJpaRepository extends JpaRepository<RefundJpaEntity, UUID> {
}
