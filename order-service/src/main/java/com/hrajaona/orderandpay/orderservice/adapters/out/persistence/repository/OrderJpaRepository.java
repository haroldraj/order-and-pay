package com.hrajaona.orderandpay.orderservice.adapters.out.persistence.repository;

import com.hrajaona.orderandpay.orderservice.adapters.out.persistence.entity.OrderJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderJpaEntity, UUID> {
}
