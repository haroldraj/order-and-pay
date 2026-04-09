package com.hrajaona.orderandpay.orderservice.application.service.payment;

import com.hrajaona.library.events.PaymentCompletedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaymentCompletedHandler implements PaymentEventHandler<PaymentCompletedEvent> {

    @Override
    public String support() {
        return "PAYMENT_COMPLETED";
    }

    @Override
    public Class<PaymentCompletedEvent> eventClass() {
        return PaymentCompletedEvent.class;
    }

    @Override
    public void handle(PaymentCompletedEvent event, String correlationId) {
        log.info("PaymentCompletedHandler: correlationId={}", correlationId);
    }

}
