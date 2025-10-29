package com.hrajaona.orderandpay.orderservice.adapters.out.persistence.repository;

import com.hrajaona.orderandpay.orderservice.adapters.out.persistence.entity.OrderItemJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemJpa, Long> {
}
