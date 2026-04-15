package com.hrajaona.orderandpay.paymentservice.application.service;

import com.hrajaona.library.enums.PaymentStatus;
import com.hrajaona.library.events.OrderCreatedEvent;
import com.hrajaona.library.events.PaymentCompletedEvent;
import com.hrajaona.orderandpay.paymentservice.adapters.in.web.dto.PaymentRequest;
import com.hrajaona.orderandpay.paymentservice.adapters.out.kafka.PaymentEventProducerAdapter;
import com.hrajaona.orderandpay.paymentservice.adapters.out.persistence.mapper.PaymentMapper;
import com.hrajaona.orderandpay.paymentservice.application.port.in.*;
import com.hrajaona.orderandpay.paymentservice.application.port.out.PaymentRepository;
import com.hrajaona.orderandpay.paymentservice.domain.exception.PaymentNotFoundException;
import com.hrajaona.orderandpay.paymentservice.domain.model.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentService implements PaymentUseCase {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final PaymentEventProducerAdapter paymentEventProducerAdapter;

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(UUID id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException(id));
    }

    @Override
    public Payment createPayment(PaymentRequest paymentRequest) {
        Payment payment = new Payment();
        LocalDateTime now = LocalDateTime.now();

        payment.setId(UUID.randomUUID());
        payment.setAmount(paymentRequest.amount());
        payment.setMethod(paymentRequest.method());
        payment.setUserId(paymentRequest.userId());
        payment.setOrderId(paymentRequest.orderId());
        payment.setReference(paymentRequest.reference());
        payment.setValueDate(now);
        payment.setStatus(PaymentStatus.valueOf(paymentRequest.status()));
        payment.setCreatedAt(now);
        payment.setUpdatedAt(now);

        return paymentRepository.save(payment);
    }

    @Override
    public void deletePayment(UUID id) {

    }

    @Override
    public Payment updatePayment(UUID id, PaymentRequest paymentRequest) {
        return null;
    }

    @Override
    public void processOrderPayment(OrderCreatedEvent orderCreatedEvent, String correlationId) {
        Payment payment  = new Payment();
        log.info("Processing Payment of OrderCreatedEvent with correlationId={}", correlationId);
//        paymentEventProducerAdapter.publishPaymentCompleted(payment, correlationId);
    }
}
