package com.hrajaona.orderandpay.paymentservice.adapters.in.kafka;

import com.hrajaona.orderandpay.paymentservice.application.service.order.OrderEventProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.header.Header;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderEventKafkaListener {
    private final OrderEventProcessor orderEventProcessor;

    @KafkaListener(topics = "order.events", groupId = "payment-group")
    public void listenOrderEvent(ConsumerRecord<String, Object> record) {
        String correlationId = getCorrelationId(record);
        String eventType = getEventType(record);
        String eventId = getEventId(record);

        log.info("Received OrderEvent with correlationId={}, eventId={} and eventType={}", correlationId, eventId, eventType);

        orderEventProcessor.process(record.value(), eventType, correlationId);
    }

    private String getCorrelationId(ConsumerRecord<String, Object> record) {
        Header header = record.headers().lastHeader("correlationId");
        return header != null ? new String(header.value()) : null;
    }

    private String getEventType(ConsumerRecord<String, Object> record) {
        Header header = record.headers().lastHeader("eventType");
        return header!= null ? new String(header.value()) : null;
    }

    private String getEventId(ConsumerRecord<String, Object> record) {
        Header header = record.headers().lastHeader("eventId");
        return header != null ? new String(header.value()) : null;
    }
}
