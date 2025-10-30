package com.hrajaona.orderandpay.orderservice.adapters.out.persistence.repository;

import com.hrajaona.orderandpay.orderservice.adapters.out.persistence.entity.OrderStatusHistoryJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStatusHistoryRepository extends JpaRepository<OrderStatusHistoryJpa, Long> {
}
