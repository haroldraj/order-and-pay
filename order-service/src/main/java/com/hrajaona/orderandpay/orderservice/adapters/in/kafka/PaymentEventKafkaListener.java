package com.hrajaona.orderandpay.orderservice.adapters.in.kafka;

import com.hrajaona.library.events.PaymentCompletedEvent;
import com.hrajaona.orderandpay.orderservice.application.port.in.PaymentCompletedUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.header.Header;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentEventKafkaListener {
    private final PaymentCompletedUseCase paymentCompletedUseCase;

    @KafkaListener(topics = "payment.completed", groupId = "order-group")
    public void listenPaymentCompleted(ConsumerRecord<String, PaymentCompletedEvent> paymentRecord) {
        String correlationId = getCorrelationId(paymentRecord);
        String eventType = getEventType(paymentRecord);

        log.info("Received {} event with correlationId {}", eventType, correlationId);

        paymentCompletedUseCase.handle(paymentRecord.value(), correlationId);
    }

    private String getCorrelationId(ConsumerRecord<String, PaymentCompletedEvent> paymentRecord) {
        Header header = paymentRecord.headers().lastHeader("correlationId");
        return header != null ? new String(header.value()) : null;
    }

    private String getEventType(ConsumerRecord<String, PaymentCompletedEvent> paymentRecord) {
        Header header = paymentRecord.headers().lastHeader("eventType");
        return header!= null ? new String(header.value()) : null;
    }
}
