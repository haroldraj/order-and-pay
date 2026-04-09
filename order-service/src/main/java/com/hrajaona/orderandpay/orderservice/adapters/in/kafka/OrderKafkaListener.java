package com.hrajaona.orderandpay.orderservice.adapters.in.kafka;

import com.hrajaona.library.events.PaymentCompletedEvent;
import com.hrajaona.orderandpay.orderservice.application.service.OrderService;
import com.hrajaona.orderandpay.orderservice.domain.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.header.Header;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderKafkaListener {
    private final OrderService orderService;

    @KafkaListener(topics = "payment.completed", groupId = "order-group")
    public void listenPaymentCompleted(ConsumerRecord<String, PaymentCompletedEvent> record) {
     String correlationId = getCorrelationId(record);

     log.info("Received PaymentCompletedEvent with correlationId={}", correlationId);

     Order order = orderService.getOrderByIdAndUserIdAndAmount(
             record.value().getOrderId(),
             record.value().getUserId(),
             record.value().getAmount());

     orderService.processOrderPayment(order, correlationId);


    }

    private String getCorrelationId(ConsumerRecord<?, ?> record) {
        Header header = record.headers().lastHeader("correlation-id");
        return header != null ? new String(header.value()) : null;
    }
}
