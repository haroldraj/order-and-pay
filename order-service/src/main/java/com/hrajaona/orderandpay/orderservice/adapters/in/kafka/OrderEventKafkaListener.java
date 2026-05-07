package com.hrajaona.orderandpay.orderservice.adapters.in.kafka;

import com.hrajaona.library.events.OrderDeliveredEvent;
import com.hrajaona.library.events.OrderPickedUpEvent;
import com.hrajaona.library.events.OrderPreparingEvent;
import com.hrajaona.library.messaging.KafkaTopics;
import com.hrajaona.library.messaging.ServiceGroupId;
import com.hrajaona.orderandpay.orderservice.application.port.in.OrderDeliveredUseCase;
import com.hrajaona.orderandpay.orderservice.application.port.in.OrderPickedUpUseCase;
import com.hrajaona.orderandpay.orderservice.application.port.in.OrderPreparingUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.header.Header;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderEventKafkaListener {
    private final OrderPreparingUseCase orderPreparingUseCase;
    private final OrderPickedUpUseCase orderPickedUpUseCase;
    private final OrderDeliveredUseCase orderDeliveredUseCase;

    @KafkaListener(topics = KafkaTopics.ORDER_PREPARING, groupId = ServiceGroupId.ORDER_GROUP)
    public void listenOrderPreparing(ConsumerRecord<String, OrderPreparingEvent> orderPreparingRecord) {
        listenEvent(orderPreparingRecord, orderPreparingUseCase::handle);
    }

    @KafkaListener(topics = KafkaTopics.ORDER_PICKED_UP, groupId = ServiceGroupId.ORDER_GROUP)
    public void listenOrderPickedUp(ConsumerRecord<String, OrderPickedUpEvent> orderPickedUpRecord) {
        listenEvent(orderPickedUpRecord, orderPickedUpUseCase::handle);
    }

    @KafkaListener(topics = KafkaTopics.ORDER_DELIVERED, groupId = ServiceGroupId.ORDER_GROUP)
    public void listenOrderDelivered(ConsumerRecord<String, OrderDeliveredEvent> orderDeliveredRecord) {
        listenEvent(orderDeliveredRecord, orderDeliveredUseCase::handle);
    }

    private <T> void listenEvent(ConsumerRecord<String, T> eventRecord, BiConsumer<T, String> handler) {
        String correlationId = getCorrelationId(eventRecord);
        String eventType = getEventType(eventRecord);

        checkCorrelationIdAndEventType(correlationId, eventType);

        logInfoReceiveEvent(correlationId, eventType);

        handler.accept(eventRecord.value(), correlationId);
    }

    private String getCorrelationId(ConsumerRecord<String, ?> record) {
        Header header = record.headers().lastHeader("correlationId");
        return header != null ? new String(header.value()) : null;
    }

    private String getEventType(ConsumerRecord<String, ?> record) {
        Header header = record.headers().lastHeader("eventType");
        return header != null ? new String(header.value()) : null;
    }

    private void checkCorrelationIdAndEventType(String correlationId, String eventType) {
        if (correlationId == null || eventType == null) {
            log.warn("CorrelationId or eventType is null. The event is ignored.");
        }
    }

    private void logInfoReceiveEvent(String correlationId, String eventType) {
        log.info("Received {} event with correlationId {}", eventType, correlationId);
    }

}
