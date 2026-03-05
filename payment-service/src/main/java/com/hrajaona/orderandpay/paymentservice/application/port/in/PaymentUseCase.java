package com.hrajaona.orderandpay.paymentservice.application.port.in;

import com.hrajaona.orderandpay.paymentservice.adapter.in.web.dto.PaymentRequest;
import com.hrajaona.orderandpay.paymentservice.domain.model.Payment;

import java.util.List;
import java.util.UUID;

public interface PaymentUseCase {
    Payment createPayment(PaymentRequest paymentRequest);
    void deletePayment(UUID id);
    Payment getPaymentById(UUID id);
    List<Payment> getAllPayments();
    Payment updatePayment(UUID id, PaymentRequest paymentRequest);

}
