package com.hrajaona.orderandpay.deliveryservice.adapters.in.kafka;

import com.hrajaona.library.events.OrderReadyForDeliveryEvent;
import com.hrajaona.library.messaging.KafkaTopics;
import com.hrajaona.library.messaging.ServiceGroupId;
import com.hrajaona.orderandpay.deliveryservice.application.port.in.HandleOrderReadyUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.header.Header;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrderEventKafkaListener {
    private final HandleOrderReadyUseCase handleOrderReadyUseCase;

    @KafkaListener(topics = KafkaTopics.ORDER_READY_FOR_DELIVERY, groupId = ServiceGroupId.DELIVERY_GROUP)
    public void listenOrderReadyForDelivery(ConsumerRecord<String, OrderReadyForDeliveryEvent> orderReadyForDeliveryRecord) {
        String correlationId = getCorrelationId(orderReadyForDeliveryRecord);
        String eventType = getEventType(orderReadyForDeliveryRecord);

        log.info("Received {} event with correlationId {}", eventType, correlationId);

        handleOrderReadyUseCase.handle(orderReadyForDeliveryRecord.value(), correlationId);


    }

    private String getCorrelationId(ConsumerRecord<String, OrderReadyForDeliveryEvent> orderReadyForDeliveryRecord) {
        Header header = orderReadyForDeliveryRecord.headers().lastHeader("correlationId");
        return header != null ? new String(header.value()) : null;
    }

    private String getEventType(ConsumerRecord<String, OrderReadyForDeliveryEvent> orderReadyForDeliveryRecord) {
        Header header = orderReadyForDeliveryRecord.headers().lastHeader("eventType");
        return header != null ? new String(header.value()) : null;
    }
}
