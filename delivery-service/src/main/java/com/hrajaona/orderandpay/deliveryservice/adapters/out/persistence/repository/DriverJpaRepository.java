package com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.repository;

import com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.entity.DriverJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DriverJpaRepository extends JpaRepository<DriverJpaEntity, UUID> {
}
