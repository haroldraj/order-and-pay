package com.hrajaona.orderandpay.deliveryservice.adapters.in.kafka;

import com.hrajaona.library.events.OrderReadyForDeliveryEvent;
import com.hrajaona.orderandpay.deliveryservice.application.port.in.HandleOrderReadyUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.header.Header;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrderEventKafkaListener {
    private final HandleOrderReadyUseCase handleOrderReadyUseCase;

//    @KafkaListener(topics = "order.paid", groupId = "delivery-group")
//    public void listen(ConsumerRecord<String, Object> record) {
////        String correlationId = getCorrelationId(record);
//
////        if (correlationId == null) {
////            throw  new RuntimeException("correlationId is null");
////        }
//        log.info("Received Order Paid event with correlationId");
////        handleOrderReadyUseCase.handle(record.value(), correlationId);
//    }

    private String getCorrelationId(ConsumerRecord<String, OrderReadyForDeliveryEvent> record) {
        Header header = record.headers().lastHeader("correlationId");
        return header != null ? new String(header.value()) : null;
    }
}
