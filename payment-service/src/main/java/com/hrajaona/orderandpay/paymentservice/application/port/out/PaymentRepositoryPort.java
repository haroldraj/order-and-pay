package com.hrajaona.orderandpay.paymentservice.application.port.out;

import com.hrajaona.orderandpay.paymentservice.domain.model.Payment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PaymentRepositoryPort {
    Payment save(Payment payment);
    List<Payment> findAll();
    Optional<Payment> findById(UUID id);
    Optional<Payment> findByOrderIdAndUserId(UUID orderId, UUID userId);
}
