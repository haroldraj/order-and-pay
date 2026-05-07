package com.hrajaona.orderandpay.restaurantservice.adapters.in.kafka;

import com.hrajaona.library.events.OrderPaidEvent;
import com.hrajaona.library.messaging.KafkaTopics;
import com.hrajaona.library.messaging.ServiceGroupId;
import com.hrajaona.orderandpay.restaurantservice.application.port.in.HandleOrderPaidUseCase;
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
    private final HandleOrderPaidUseCase handleOrderPaidUseCase;

    @KafkaListener(topics = KafkaTopics.ORDER_PAID, groupId = ServiceGroupId.RESTAURANT_GROUP)
    public void listenOrderPaid(ConsumerRecord<String, OrderPaidEvent> orderPaidRecord) {
        String correlationId = getCorrelationId(orderPaidRecord);
        String eventType = getEventType(orderPaidRecord);

        log.info("Received {} event with correlationId {}", eventType, correlationId);

        handleOrderPaidUseCase.handle(orderPaidRecord.value(), correlationId);
    }

    private String getCorrelationId(ConsumerRecord<String, OrderPaidEvent> orderPaidRecord) {
        Header header = orderPaidRecord.headers().lastHeader("correlationId");
        return header != null ? new String(header.value()) : null;
    }

    private String getEventType(ConsumerRecord<String, OrderPaidEvent> orderPaidRecord) {
        Header header = orderPaidRecord.headers().lastHeader("eventType");
        return header != null ? new String(header.value()) : null;
    }
}
