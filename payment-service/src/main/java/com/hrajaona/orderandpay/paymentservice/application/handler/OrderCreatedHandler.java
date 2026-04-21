package com.hrajaona.orderandpay.paymentservice.application.handler;

import com.hrajaona.library.events.OrderCreatedEvent;
import com.hrajaona.orderandpay.paymentservice.application.mapper.PaymentApplicationMapper;
import com.hrajaona.orderandpay.paymentservice.application.port.in.HandleOrderCreatedUseCase;
import com.hrajaona.orderandpay.paymentservice.application.port.out.PaymentEventProducerPort;
import com.hrajaona.orderandpay.paymentservice.application.port.out.PaymentRepositoryPort;
import com.hrajaona.orderandpay.paymentservice.domain.model.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class OrderCreatedHandler implements HandleOrderCreatedUseCase {
    private final PaymentRepositoryPort paymentRepositoryPort;
    private final PaymentEventProducerPort paymentEventProducerPort;
    private final PaymentApplicationMapper mapper;

    @Override
    public void handle(OrderCreatedEvent event, String correlationId) {
        validateOrderCreatedEvent(event);

        Payment payment = mapper.toDomain(event);

        payment.markAsCompleted();

        Payment savedPayment = paymentRepositoryPort.save(payment);

        paymentEventProducerPort.publishPaymentCompleted(mapper.toPaymentCompletedEvent(savedPayment), correlationId);
    }

    private void validateOrderCreatedEvent(OrderCreatedEvent event) {
        paymentRepositoryPort.findByOrderIdAndUserId(event.getOrderId(), event.getUserId())
                .ifPresent(p -> {
                    throw new RuntimeException("Payment with orderId=" + event.getOrderId()
                            + " and userId=" + event.getUserId() + " already exists");
                });
    }
}
