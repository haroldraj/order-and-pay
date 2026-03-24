package com.hrajaona.orderandpay.paymentservice.adapter.in.kafka;

import com.hrajaona.library.events.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.header.Header;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentKafkaListener {

    @KafkaListener(topics = "order.created", groupId = "payment-group")
    public void listen(ConsumerRecord<String, OrderCreatedEvent> record) {
        String correlationId = getCorrelationId(record);

        log.info("Received OrderCreatedEvent with correlationId {}", correlationId);
    }

    private String getCorrelationId(ConsumerRecord<?, ?> record) {
        Header header = record.headers().lastHeader("correlation-id");
        return header != null ? new String(header.value()) : null;
    }
}
