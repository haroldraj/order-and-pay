package com.hrajaona.orderandpay.orderservice.adapters.out.persistence.repository;

import com.hrajaona.orderandpay.orderservice.adapters.out.persistence.entity.OrderItemJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderItemJpaRepository extends JpaRepository<OrderItemJpaEntity, UUID> {
}
