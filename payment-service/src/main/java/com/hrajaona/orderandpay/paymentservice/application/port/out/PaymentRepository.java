package com.hrajaona.orderandpay.paymentservice.application.port.out;

import com.hrajaona.orderandpay.paymentservice.adapter.out.persistence.entity.PaymentJpaEntity;
import com.hrajaona.orderandpay.paymentservice.domain.model.Payment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PaymentRepository {
    Payment save(Payment payment);
    List<Payment> findAll();
    Optional<Payment> findById(UUID id);
}
