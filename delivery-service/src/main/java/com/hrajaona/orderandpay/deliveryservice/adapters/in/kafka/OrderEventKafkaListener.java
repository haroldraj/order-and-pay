package com.hrajaona.orderandpay.deliveryservice.adapters.in.kafka;

import com.hrajaona.library.events.OrderPaidEvent;
import com.hrajaona.library.events.OrderReadyForDelivery;
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

    @KafkaListener(topics = "order.ready-for-delivery", groupId = "delivery-group")
    public void listen(ConsumerRecord<String, OrderReadyForDelivery> record) {
        String correlationId = getCorrelationId(record);

        if (correlationId == null) {
            throw  new RuntimeException("correlationId is null");
        }
        log.info("Received OrderReadyForDelivery event with correlationId={}", correlationId);
        handleOrderReadyUseCase.handle(record.value(), correlationId);
    }

    private String getCorrelationId(ConsumerRecord<String, OrderReadyForDelivery> record) {
        Header header = record.headers().lastHeader("correlationId");
        return header != null ? new String(header.value()) : null;
    }
}
