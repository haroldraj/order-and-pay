package com.hrajaona.orderandpay.paymentservice.adapters.in.kafka;

import com.hrajaona.library.events.OrderCreatedEvent;
import com.hrajaona.library.messaging.KafkaTopics;
import com.hrajaona.library.messaging.ServiceGroupId;
import com.hrajaona.orderandpay.paymentservice.application.port.in.HandleOrderCreatedUseCase;
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
    private final HandleOrderCreatedUseCase handleOrderCreatedUseCase;

    @KafkaListener(topics = KafkaTopics.ORDER_CREATED, groupId = ServiceGroupId.PAYMENT_GROUP)
    public void listenOrderCreated(ConsumerRecord<String, OrderCreatedEvent> record) {
        String correlationId = getCorrelationId(record);
        String eventType = getEventType(record);

        log.info("Received {} event with correlationId {}", eventType, correlationId);

        handleOrderCreatedUseCase.handle(record.value(), correlationId);
    }

    private String getCorrelationId(ConsumerRecord<String, OrderCreatedEvent> record) {
        Header header = record.headers().lastHeader("correlationId");
        return header != null ? new String(header.value()) : null;
    }

    private String getEventType(ConsumerRecord<String, OrderCreatedEvent> record) {
        Header header = record.headers().lastHeader("eventType");
        return header!= null ? new String(header.value()) : null;
    }
}
