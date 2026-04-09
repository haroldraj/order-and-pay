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

    @Override
    public void publishPaymentCompleted(Payment payment , String correlationId) {
        UUID eventId = UUID.randomUUID();

        PaymentCompletedEvent paymentCompletedEvent = new PaymentCompletedEvent();

        log.info("Sending PaymentCompletedEvent with correlationId={} and eventId={} to topic={}", correlationId, eventId, paymentEventsTopic.name());

        ProducerRecord<String, PaymentCompletedEvent> record = new ProducerRecord<>(paymentEventsTopic.name(), UUID.randomUUID().toString(), paymentCompletedEvent);

        record.headers().add("correlationId", correlationId.getBytes());
        record.headers().add("eventType", "PAYMENT_COMPLETED".getBytes());


        kafkaTemplate.send(record);

    }
}
