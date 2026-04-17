package com.hrajaona.orderandpay.paymentservice.adapters.out.kafka;

import com.hrajaona.library.events.PaymentCompletedEvent;
import com.hrajaona.orderandpay.paymentservice.application.port.out.PaymentEventProducer;
import com.hrajaona.orderandpay.paymentservice.domain.model.Payment;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
@Getter
@Setter
public class PaymentEventProducerAdapter implements PaymentEventProducer {
    private final NewTopic paymentEventsTopic;
    private final KafkaTemplate<String, PaymentCompletedEvent> kafkaTemplate;
    private final String PAYMENT_COMPLETED_EVENT = "PAYMENT_COMPLETED";
    private final String PAYMENT_COMPLETED_TOPIC = "payment.completed";

    @Override
    public void publishPaymentCompleted(PaymentCompletedEvent payment , String correlationId) {
        UUID eventId = UUID.randomUUID();

        payment.setEventId(eventId);

        log.info("Sending {} event with correlationId {}", PAYMENT_COMPLETED_EVENT, correlationId);

        ProducerRecord<String, PaymentCompletedEvent> record = new ProducerRecord<>(PAYMENT_COMPLETED_TOPIC, payment.getPaymentId().toString(), payment);

        record.headers().add("correlationId", correlationId.getBytes());
        record.headers().add("eventType", PAYMENT_COMPLETED_EVENT.getBytes());


        kafkaTemplate.send(record);

    }
}
