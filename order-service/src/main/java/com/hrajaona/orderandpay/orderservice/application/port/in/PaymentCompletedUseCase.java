package com.hrajaona.orderandpay.orderservice.application.port.in;

import com.hrajaona.library.events.PaymentCompletedEvent;

public interface PaymentCompletedUseCase {
    void handle(PaymentCompletedEvent event, String correlationId);
}
