package com.hrajaona.orderandpay.paymentservice.application.port.out;

import com.hrajaona.orderandpay.paymentservice.domain.model.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository {
    void save(Payment payment);
    List<Payment> findAllPayments();
    Optional<Payment> findById(Long id);
}
