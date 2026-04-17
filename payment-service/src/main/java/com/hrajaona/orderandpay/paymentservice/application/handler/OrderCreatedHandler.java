package com.hrajaona.orderandpay.paymentservice.application.handler;

import com.hrajaona.library.events.OrderCreatedEvent;
import com.hrajaona.orderandpay.paymentservice.application.mapper.PaymentApplicationMapper;
import com.hrajaona.orderandpay.paymentservice.application.port.in.OrderCreatedUseCase;
import com.hrajaona.orderandpay.paymentservice.application.port.out.PaymentEventProducer;
import com.hrajaona.orderandpay.paymentservice.application.port.out.PaymentRepository;
import com.hrajaona.orderandpay.paymentservice.domain.model.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class OrderCreatedHandler implements OrderCreatedUseCase {
    private final PaymentRepository  paymentRepository;
    private final PaymentEventProducer paymentEventProducer;
    private final PaymentApplicationMapper mapper;

    @Override
    public void handle(OrderCreatedEvent event, String correlationId) {
        validateOrderCreatedEvent(event);

        Payment payment = mapper.toDomain(event);

        payment.markAsCompleted();

        Payment savedPayment = paymentRepository.save(payment);

        paymentEventProducer.publishPaymentCompleted(mapper.toPaymentCompletedEvent(savedPayment), correlationId);
    }

    private void validateOrderCreatedEvent(OrderCreatedEvent event) {
        paymentRepository.findByOrderIdAndUserId(event.getOrderId(), event.getUserId())
                .ifPresent(p -> {
                    throw new RuntimeException("Payment with orderId=" + event.getOrderId()
                            + " and userId=" + event.getUserId() + " already exists");
                });
    }
}
