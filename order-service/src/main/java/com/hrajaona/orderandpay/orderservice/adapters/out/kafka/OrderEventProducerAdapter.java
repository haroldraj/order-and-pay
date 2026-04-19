package com.hrajaona.orderandpay.orderservice.adapters.out.kafka;

import com.hrajaona.library.enums.OrderEvent;
import com.hrajaona.library.events.OrderCreatedEvent;
import com.hrajaona.library.events.OrderPaidEvent;
import com.hrajaona.library.messaging.KafkaTopics;
import com.hrajaona.orderandpay.orderservice.adapters.out.client.user.UserClient;
import com.hrajaona.orderandpay.orderservice.adapters.out.kafka.mapper.OrderEventMapper;
import com.hrajaona.orderandpay.orderservice.application.port.out.OrderEventProducerPort;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@Getter
@Setter
@RequiredArgsConstructor
public class OrderEventProducerAdapter implements OrderEventProducerPort {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final OrderEventMapper orderEventMapper;
    private final UserClient userClient;

    @Override
    public void publishOrderCreated(OrderCreatedEvent orderCreatedEvent, String correlationId) {

        orderCreatedEvent.setEventId(UUID.randomUUID());

        logInfoSendingEvent(OrderEvent.ORDER_CREATED, correlationId);

        ProducerRecord<String, Object> record = new ProducerRecord<>(KafkaTopics.ORDER_CREATED, orderCreatedEvent.getOrderId().toString(), orderCreatedEvent);

        addHeaders(record, correlationId, OrderEvent.ORDER_CREATED);

        kafkaTemplate.send(record);
    }

    @Override
    public void publishOrderPaid(OrderPaidEvent event, String correlationId) {
        event.setEventId(UUID.randomUUID());

        logInfoSendingEvent(OrderEvent.ORDER_PAID, correlationId);

        ProducerRecord<String, Object> record = new ProducerRecord<>(KafkaTopics.ORDER_PAID, event.getOrderId().toString(), event);

        addHeaders(record, correlationId, OrderEvent.ORDER_PAID);

        kafkaTemplate.send(record);
    }

    private void addHeaders(ProducerRecord<String, Object> record, String correlationId, OrderEvent orderEvent) {
        record.headers().add("correlationId", correlationId.getBytes());
        record.headers().add("eventType", orderEvent.toString().getBytes());
    }

    private void logInfoSendingEvent(OrderEvent orderEvent, String correlationId) {
        log.info("Sending {} event with correlationId {}", orderEvent, correlationId);
    }
}