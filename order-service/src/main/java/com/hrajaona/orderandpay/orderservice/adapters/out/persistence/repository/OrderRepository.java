package com.hrajaona.orderandpay.orderservice.adapters.out.persistence.repository;

import com.hrajaona.orderandpay.orderservice.adapters.out.persistence.entity.OrderJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderJpa, Long> {
}
