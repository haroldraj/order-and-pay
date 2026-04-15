package com.hrajaona.orderandpay.restaurantservice.adapters.out.kafka;

import com.hrajaona.library.events.OrderReadyForDelivery;
import com.hrajaona.orderandpay.restaurantservice.application.port.out.OrderEventProducer;
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
public class OrderEventProducerAdapter implements OrderEventProducer {
    private final KafkaTemplate<String, OrderReadyForDelivery> kafkaTemplate;
    private final String ORDER_READY_FOR_DELIVERY_TOPIC = "order.ready-for-delivery";
    private final String ORDER_READY_FOR_DELIVERY_EVENT = "ORDER_READY_FOR_DELIVERY_EVENT";

    @Override
    public void publishOrderReadyForDelivery(OrderReadyForDelivery orderReadyForDelivery, String correlationId) {
        UUID eventId = UUID.randomUUID();
        UUID orderId = UUID.randomUUID();

        orderReadyForDelivery.setOrderId(orderId);
        orderReadyForDelivery.setEventId(eventId);

        log.info("Sending OrderReadyForDelivery event with correlationId={}", correlationId);

        ProducerRecord<String, OrderReadyForDelivery> record = new ProducerRecord<>(ORDER_READY_FOR_DELIVERY_TOPIC, orderId.toString(), orderReadyForDelivery);

        addHeaders(record, correlationId, eventId.toString());

        kafkaTemplate.send(record);
    }

    private void addHeaders(ProducerRecord<String, OrderReadyForDelivery> record, String correlationId, String eventId) {
        record.headers().add("correlationId", correlationId.getBytes());
        record.headers().add("eventId", eventId.getBytes());
        record.headers().add("eventType", ORDER_READY_FOR_DELIVERY_EVENT.getBytes());
    }
}
