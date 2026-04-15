package com.hrajaona.orderandpay.orderservice.adapters.in.kafka;

import com.hrajaona.library.events.PaymentCompletedEvent;
import com.hrajaona.orderandpay.orderservice.application.service.OrderService;
import com.hrajaona.orderandpay.orderservice.application.service.payment.PaymentEventProcessor;
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
public class PaymentEventKafkaListener {
    private final OrderService orderService;
    private final PaymentEventProcessor paymentEventProcessor;

    @KafkaListener(topics = "payment.events", groupId = "order-group")
    public void listenPaymentCompleted(ConsumerRecord<String, Object> record) {
     String correlationId = getCorrelationId(record);
     String eventType = getEventType(record);

     log.info("Received {} event with correlationId={}", eventType, correlationId);

     paymentEventProcessor.process(record.value(), eventType, correlationId);

    }

    private String getCorrelationId(ConsumerRecord<?, ?> record) {
        Header header = record.headers().lastHeader("correlationId");
        return header != null ? new String(header.value()) : null;
    }

    private String getEventType(ConsumerRecord<?, ?> record) {
        Header header = record.headers().lastHeader("eventType");
        return header!= null ? new String(header.value()) : null;
    }
}
