package com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.repository;

import com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.entity.DeliveryAssignmentId;
import com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.entity.DeliveryAssignmentJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryAssignmentJpaRepository extends JpaRepository<DeliveryAssignmentJpaEntity, DeliveryAssignmentId> {
}
