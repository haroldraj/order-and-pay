package com.hrajaona.orderandpay.paymentservice.application.port.out;

import com.hrajaona.orderandpay.paymentservice.domain.model.Payment;

public interface PaymentEventProducer {
    void publishPaymentCompleted(Payment payment, String correlationId);
}
