package com.hrajaona.orderandpay.paymentservice.application.port.out;

import com.hrajaona.library.events.PaymentCompletedEvent;

public interface PaymentEventProducerPort {
    void publishPaymentCompleted(PaymentCompletedEvent event, String correlationId);
}
