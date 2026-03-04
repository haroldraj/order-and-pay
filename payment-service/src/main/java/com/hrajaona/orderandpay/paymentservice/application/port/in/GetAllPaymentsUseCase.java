package com.hrajaona.orderandpay.paymentservice.application.port.in;

import com.hrajaona.orderandpay.paymentservice.domain.model.Payment;
import com.hrajaona.orderandpay.paymentservice.domain.port.PaymentRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class GetAllPaymentsUseCase {
    private final PaymentRepository paymentRepository;

    public List<Payment> call() {
        return paymentRepository.findAll();
    }
}
