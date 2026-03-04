package com.hrajaona.orderandpay.paymentservice.adapter.out.persistence;

import com.hrajaona.orderandpay.paymentservice.adapter.out.persistence.entity.PaymentJpaEntity;
import com.hrajaona.orderandpay.paymentservice.adapter.out.persistence.repository.PaymentJpaRepository;
import com.hrajaona.orderandpay.paymentservice.application.port.out.PaymentRepository;
import com.hrajaona.orderandpay.paymentservice.domain.model.Payment;
import com.hrajaona.orderandpay.paymentservice.adapter.out.persistence.mapper.PaymentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class PaymentPersistenceAdapter implements PaymentRepository {
    private final PaymentJpaRepository paymentJpaRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public void save(Payment payment) {
        PaymentJpaEntity jpa = paymentMapper.toEntity(payment);
        paymentJpaRepository.save(jpa);
    }

    @Override
    public List<Payment> findAllPayments() {
        return paymentJpaRepository.findAll()
                .stream()
                .map(paymentMapper::toDomain)
                .toList();
    }


    @Override
    public Optional<Payment> findById(Long id) {
        return Optional.empty();
    }
}
