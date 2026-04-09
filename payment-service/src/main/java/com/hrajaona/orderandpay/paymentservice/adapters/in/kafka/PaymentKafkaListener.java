package com.hrajaona.orderandpay.paymentservice.adapters.in.kafka;

import com.hrajaona.library.events.OrderCreatedEvent;
import com.hrajaona.orderandpay.paymentservice.application.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.header.Header;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentKafkaListener {
    private final PaymentService paymentService;

    @KafkaListener(topics = "order.created", groupId = "payment-group")
    public void listen(ConsumerRecord<String, OrderCreatedEvent> record) {
        String correlationId = getCorrelationId(record);

        OrderCreatedEvent event = record.value();

        log.info("Received OrderCreatedEvent with correlationId={} and eventId={}", correlationId, event.getEventId());

        paymentService.processOrderPayment(event, correlationId);

    }

    private String getCorrelationId(ConsumerRecord<?, ?> record) {
        Header header = record.headers().lastHeader("correlationId");
        return header != null ? new String(header.value()) : null;
    }
}
