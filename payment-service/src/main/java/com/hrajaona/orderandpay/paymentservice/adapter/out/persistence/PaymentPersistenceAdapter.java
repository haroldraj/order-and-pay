package com.hrajaona.orderandpay.paymentservice.adapter.out.persistence;

import com.hrajaona.orderandpay.paymentservice.adapter.out.persistence.entity.PaymentJpaEntity;
import com.hrajaona.orderandpay.paymentservice.adapter.out.persistence.mapper.PaymentMapper;
import com.hrajaona.orderandpay.paymentservice.adapter.out.persistence.repository.PaymentJpaRepository;
import com.hrajaona.orderandpay.paymentservice.application.port.out.PaymentRepository;
import com.hrajaona.orderandpay.paymentservice.domain.model.Payment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class PaymentPersistenceAdapter implements PaymentRepository {
    private final PaymentJpaRepository paymentJpaRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public Payment save(Payment payment) {
        PaymentJpaEntity savedPayment = paymentJpaRepository.save(paymentMapper.toEntity(payment));
        return  paymentMapper.toDomain(savedPayment);
    }

    @Override
    public List<Payment> findAll() {
        return paymentJpaRepository.findAll()
                .stream()
                .map(paymentMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Payment> findById(UUID id) {
        return paymentJpaRepository.findById(id).map(paymentMapper::toDomain);
    }
}
