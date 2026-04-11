package com.hrajaona.orderandpay.paymentservice.application.service.order;

import com.hrajaona.library.events.OrderCreatedEvent;

public class OrderCreatedHandler implements OrderEventHandler<OrderCreatedEvent>{
    @Override
    public String support() {
        return "ORDER_CREATED";
    }

    @Override
    public void handle(OrderCreatedEvent event, String correlationId) {

    }
}
