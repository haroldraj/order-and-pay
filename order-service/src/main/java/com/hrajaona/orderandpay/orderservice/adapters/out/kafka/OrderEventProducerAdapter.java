package com.hrajaona.orderandpay.orderservice.adapters.out.kafka;

import com.hrajaona.library.events.OrderCreatedEvent;
import com.hrajaona.orderandpay.orderservice.application.port.out.OrderEventProducerPort;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Getter
@Setter
@RequiredArgsConstructor
public class OrderEventProducerAdapter implements OrderEventProducerPort {
    private final NewTopic topic;
    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;
    private final String ORDER_CREATED = "OrderCreated";
    private final String ORDER_SERVICE = "order-service";

    @Override
    public void publishOrderCreated(OrderCreatedEvent orderCreatedEvent, String correlationId) {
        log.info("Sending OrderCreatedEvent with correlationId={}, orderId={}, userId={}, totalAmount={}, valueDate={}",
                correlationId,
                orderCreatedEvent.getOrderId(),
                orderCreatedEvent.getUserId(),
                orderCreatedEvent.getTotalAmount(),
                orderCreatedEvent.getValueDate());

      ProducerRecord<String, OrderCreatedEvent> record = new ProducerRecord<>(topic.name(), correlationId, orderCreatedEvent);

      record.headers().add("correlation-id", correlationId.getBytes());
      record.headers().add("event-type", ORDER_CREATED.getBytes());
      record.headers().add("producer", ORDER_SERVICE.getBytes());

      kafkaTemplate.send(record);
    }
}