package com.hrajaona.orderandpay.paymentservice.application.service.order;

public interface OrderEventHandler<T> {
    String support();
    void handle(T event, String correlationId);
}
