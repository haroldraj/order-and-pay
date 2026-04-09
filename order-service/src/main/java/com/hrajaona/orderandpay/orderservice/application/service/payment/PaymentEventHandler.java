package com.hrajaona.orderandpay.orderservice.application.service.payment;

import org.springframework.stereotype.Component;

@Component
public interface PaymentEventHandler<T> {
    String support();
    Class<T> eventClass();
    void handle(T event, String correlationId);
}
