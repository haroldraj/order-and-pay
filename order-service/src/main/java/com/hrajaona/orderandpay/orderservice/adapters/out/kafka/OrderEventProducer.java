package com.hrajaona.orderandpay.orderservice.adapters.out.kafka;

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
public class OrderEventProducer {
    private final NewTopic topic;
    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

//    public OrderEventProducer(NewTopic topic, KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate) {
//        this.topic = topic;
//        this.kafkaTemplate = kafkaTemplate;
//    }

    public void sendMessage(OrderCreatedEvent orderCreatedEvent) {
        log.info("Sending order event to kafka topic: {}", orderCreatedEvent.toString());

        Message<OrderCreatedEvent> message = MessageBuilder
                .withPayload(orderCreatedEvent)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();

        kafkaTemplate.send(message);
    }
}
