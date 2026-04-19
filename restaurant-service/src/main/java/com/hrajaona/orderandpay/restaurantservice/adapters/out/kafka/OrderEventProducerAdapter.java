package com.hrajaona.orderandpay.restaurantservice.adapters.out.kafka;

import com.hrajaona.library.enums.OrderEvent;
import com.hrajaona.library.events.OrderPreparingEvent;
import com.hrajaona.library.events.OrderReadyForDeliveryEvent;
import com.hrajaona.library.messaging.KafkaTopics;
import com.hrajaona.orderandpay.restaurantservice.application.port.out.OrderEventProducerPort;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
@Getter
public class OrderEventProducerAdapter implements OrderEventProducerPort {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void publishOrderReadyForDelivery(OrderReadyForDeliveryEvent orderEvent, String correlationId) {
        UUID eventId = UUID.randomUUID();

        orderEvent.setEventId(eventId);

        ProducerRecord<String, Object> record = new ProducerRecord<>(
                KafkaTopics.ORDER_READY_FOR_DELIVERY, orderEvent.getOrderId().toString(), orderEvent);

        addHeaders(record, correlationId, OrderEvent.ORDER_READY_FOR_DELIVERY.toString());

        logInfoEventSending(OrderEvent.ORDER_READY_FOR_DELIVERY, correlationId);

        kafkaTemplate.send(record);
    }

    @Override
    public void publishOrderPreparing(OrderPreparingEvent orderPreparingEvent, String correlationId) {
        UUID eventId = UUID.randomUUID();

        orderPreparingEvent.setEventId(eventId);

        ProducerRecord<String, Object> record = new ProducerRecord<>(
                KafkaTopics.ORDER_PREPARING, orderPreparingEvent.getOrderId().toString(), orderPreparingEvent);

        addHeaders(record, correlationId, OrderEvent.ORDER_PREPARING.toString());

        logInfoEventSending(OrderEvent.ORDER_PREPARING, correlationId);

        kafkaTemplate.send(record);
    }

    private void addHeaders(ProducerRecord<String, Object> record, String correlationId, String eventType) {
        record.headers().add("correlationId", correlationId.getBytes());
        record.headers().add("eventType", eventType.getBytes());
    }

    private void logInfoEventSending(OrderEvent eventType, String correlationId) {
        log.info("Sending {} event with correlationId {}", eventType, correlationId);
    }
}
