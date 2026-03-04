package com.hrajaona.orderandpay.paymentservice.domain.port;

import com.hrajaona.orderandpay.paymentservice.domain.model.Refund;
import com.hrajaona.orderandpay.paymentservice.infrastructure.persistence.entity.RefundEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RefundRepository extends JpaRepository<RefundEntity, Long> {
    List<RefundEntity> findAll();
    Optional<RefundEntity> findById(Long id);
    Optional<RefundEntity> findByRefundIdf(UUID refundIdf);
}
