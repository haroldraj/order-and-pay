package com.hrajaona.orderandpay.restaurantservice.application.port.handler;

import com.hrajaona.library.events.OrderPaidEvent;
import com.hrajaona.library.events.OrderReadyForDelivery;
import com.hrajaona.orderandpay.restaurantservice.application.port.in.OrderPaidUseCase;
import com.hrajaona.orderandpay.restaurantservice.application.port.out.OrderEventProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderPaidHandler implements OrderPaidUseCase {
    private final OrderEventProducer orderEventProducer;

    @Override
    public void handle(OrderPaidEvent event, String correlationId) {
        OrderReadyForDelivery orderReadyForDelivery = new OrderReadyForDelivery();

        orderEventProducer.publishOrderReadyForDelivery(orderReadyForDelivery, correlationId);
    }
}
