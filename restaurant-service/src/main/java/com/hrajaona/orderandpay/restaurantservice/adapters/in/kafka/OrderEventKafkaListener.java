package com.hrajaona.orderandpay.restaurantservice.adapters.in.kafka;


import com.hrajaona.library.events.OrderPaidEvent;
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
    private final String ORDER_PAID_EVENT = "OrderPaidEvent";

    @KafkaListener(topics = "order.paid", groupId = "restaurant-group")
    public void listenOrderEvent(ConsumerRecord<String, OrderPaidEvent> record) {
        String correlationId = getCorrelationId(record);

        log.info("Received OrderPaidEvent with correlationId={}", correlationId);
    }

    private String getCorrelationId(ConsumerRecord<String, OrderPaidEvent> record) {
        Header header = record.headers().lastHeader("correlationId");
        return header != null ? new String(header.value()) : null;
    }
}
