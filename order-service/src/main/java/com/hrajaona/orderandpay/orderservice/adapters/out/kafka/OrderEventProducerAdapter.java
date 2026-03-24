package com.hrajaona.orderandpay.orderservice.adapters.out.kafka;

import com.hrajaona.orderandpay.orderservice.application.port.out.OrderEventProducerPort;
import com.hrajaona.orderandpay.orderservice.domain.event.OrderCreatedEvent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@Getter
@Setter
@RequiredArgsConstructor
public class OrderEventProducerAdapter implements OrderEventProducerPort {
    private final NewTopic topic;
    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    @Override
    public void publishOrderCreated(OrderCreatedEvent orderCreatedEvent) {
        log.info("Sending OrderCreatedEvent  orderId={}, userId={}, totalAmount={}, valueDate={}",
                orderCreatedEvent.getId(),
                orderCreatedEvent.getUserId(),
                orderCreatedEvent.getTotalAmount(),
                orderCreatedEvent.getValueDate());
        Message<OrderCreatedEvent> message = MessageBuilder
                .withPayload(orderCreatedEvent)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();

        kafkaTemplate.send(message);
    }
}