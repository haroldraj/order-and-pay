package com.hrajaona.order_and_pay.adapters.out.repository;

import com.hrajaona.order_and_pay.adapters.out.persistence.DeliveryJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<DeliveryJpa, Long> {
}
