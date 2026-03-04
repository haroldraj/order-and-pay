package com.hrajaona.orderandpay.paymentservice.domain.port;

import com.hrajaona.orderandpay.paymentservice.domain.model.Payment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PaymentRepository {
    List<Payment> findAll();
    Optional<Payment> findById(Long id);
    Optional<Payment> findByPaymentIdf(UUID paymentIdf);
}
