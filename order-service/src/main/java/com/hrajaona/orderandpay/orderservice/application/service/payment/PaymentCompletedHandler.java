package com.hrajaona.orderandpay.orderservice.application.service.payment;

import com.hrajaona.library.events.PaymentCompletedEvent;
import com.hrajaona.library.model.AddressSnapshot;
import com.hrajaona.orderandpay.orderservice.application.port.out.OrderEventProducerPort;
import com.hrajaona.orderandpay.orderservice.domain.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentCompletedHandler implements PaymentEventHandler<PaymentCompletedEvent> {
    private final OrderEventProducerPort  orderEventProducerPort;

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

        Order order = new Order();
        order.setUserId(UUID.fromString("2cfa4b4f-89d1-4d47-8f5b-073dfe4a07b8"));
        order.setId(UUID.randomUUID());
        order.setAmount(BigDecimal.ZERO);
        order.setValueDate(LocalDateTime.now());
        order.setRestaurantId(UUID.randomUUID());
        order.setAddressSnapshot(new AddressSnapshot());


        orderEventProducerPort.publishOrderPaid(order, correlationId);

    }

}
