package com.hrajaona.orderandpay.orderservice.adapters.out.kafka;

import com.hrajaona.library.events.OrderCreatedEvent;
import com.hrajaona.library.events.OrderPaidEvent;
import com.hrajaona.library.model.CustomerSnapshot;
import com.hrajaona.orderandpay.orderservice.adapters.out.client.user.UserClient;
import com.hrajaona.orderandpay.orderservice.adapters.out.client.user.UserResponseDto;
import com.hrajaona.orderandpay.orderservice.adapters.out.kafka.mapper.OrderEventMapper;
import com.hrajaona.orderandpay.orderservice.application.port.out.OrderEventProducerPort;
import com.hrajaona.orderandpay.orderservice.domain.model.Order;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
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
    private final String ORDER_CREATED_EVENT = "ORDER_CREATED";
    private final String ORDER_CREATED_TOPIC = "order.created";
    private final String ORDER_PAID_EVENT = "ORDER_PAID";
    private final String ORDER_PAID_TOPIC = "order.paid";

    @Override
    public void publishOrderCreated(OrderCreatedEvent orderCreatedEvent, String correlationId) {

        orderCreatedEvent.setEventId(UUID.randomUUID());

        logInfoSendingEvent(ORDER_CREATED_EVENT, correlationId);

        ProducerRecord<String, Object> record = new ProducerRecord<>(ORDER_CREATED_TOPIC, orderCreatedEvent.getOrderId().toString(), orderCreatedEvent);

        addHeaders(record, correlationId, ORDER_CREATED_EVENT);

        kafkaTemplate.send(record);
    }

    @Override
    public void publishOrderPaid(OrderPaidEvent event, String correlationId) {
        event.setEventId(UUID.randomUUID());
//        UserResponseDto userResponseDto = userClient.getUser(order.getUserId());
//        OrderPaidEvent orderPaidEvent = getOrderPaidEvent(order, userResponseDto, eventId);

        logInfoSendingEvent(ORDER_PAID_EVENT, correlationId);

        ProducerRecord<String, Object> record = new ProducerRecord<>(ORDER_PAID_EVENT, event.getOrderId().toString(), event);

        addHeaders(record, correlationId, ORDER_PAID_EVENT);

        kafkaTemplate.send(record);
    }

    private void addHeaders(ProducerRecord<String, Object> record, String correlationId, String eventType) {
        record.headers().add("correlationId", correlationId.getBytes());
        record.headers().add("eventType", eventType.getBytes());
    }

    private void logInfoSendingEvent(String eventType, String correlationId) {
        log.info("Sending {} event with correlationId {}", eventType, correlationId);
    }
}