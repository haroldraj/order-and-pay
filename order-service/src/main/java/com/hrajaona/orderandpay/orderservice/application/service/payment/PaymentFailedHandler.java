package com.hrajaona.orderandpay.orderservice.application.service.payment;

import com.hrajaona.library.events.PaymentFailedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaymentFailedHandler implements PaymentEventHandler<PaymentFailedEvent>{
    @Override
    public String support() {
        return "PAYMENT_FAILED";
    }

    @Override
    public Class<PaymentFailedEvent> eventClass() {
        return PaymentFailedEvent.class;
    }

    @Override
    public void handle(PaymentFailedEvent event, String correlationId) {
        log.info("PaymentFailedHandler: correlationId={}", correlationId);
    }
}
