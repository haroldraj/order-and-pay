package com.hrajaona.orderandpay.paymentservice.application.service;

import com.hrajaona.orderandpay.paymentservice.application.port.in.GetAllPaymentsUseCase;
import com.hrajaona.orderandpay.paymentservice.application.port.in.GetPaymentUseCase;
import com.hrajaona.orderandpay.paymentservice.application.port.out.PaymentRepository;
import com.hrajaona.orderandpay.paymentservice.domain.model.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService implements GetAllPaymentsUseCase, GetPaymentUseCase {
    private final PaymentRepository paymentRepository;

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAllPayments();
    }

    @Override
    public Payment getPayment(Long id) {
        try {
            return paymentRepository.findById(id).orElseThrow(()-> new Exception(id.toString()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
