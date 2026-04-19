package com.hrajaona.orderandpay.paymentservice.adapters.out.kafka;

import com.hrajaona.library.enums.PaymentEvent;
import com.hrajaona.library.events.PaymentCompletedEvent;
import com.hrajaona.library.messaging.KafkaTopics;
import com.hrajaona.orderandpay.paymentservice.application.port.out.PaymentEventProducerPort;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
@Getter
@Setter
public class PaymentEventProducerAdapter implements PaymentEventProducerPort {
    private final KafkaTemplate<String, PaymentCompletedEvent> kafkaTemplate;

    @Override
    public void publishPaymentCompleted(PaymentCompletedEvent payment , String correlationId) {
        UUID eventId = UUID.randomUUID();

        payment.setEventId(eventId);

        log.info("Sending {} event with correlationId {}", PaymentEvent.PAYMENT_COMPLETED, correlationId);

        ProducerRecord<String, PaymentCompletedEvent> record = new ProducerRecord<>(KafkaTopics.PAYMENT_COMPLETED, payment.getPaymentId().toString(), payment);

        record.headers().add("correlationId", correlationId.getBytes());
        record.headers().add("eventType", PaymentEvent.PAYMENT_COMPLETED.toString().getBytes());


        kafkaTemplate.send(record);

    }
}
