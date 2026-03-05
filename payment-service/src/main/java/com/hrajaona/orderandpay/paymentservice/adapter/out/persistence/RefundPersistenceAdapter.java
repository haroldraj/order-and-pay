package com.hrajaona.orderandpay.paymentservice.adapter.out.persistence;

import com.hrajaona.orderandpay.paymentservice.adapter.out.persistence.entity.RefundJpaEntity;
import com.hrajaona.orderandpay.paymentservice.adapter.out.persistence.repository.RefundJpaRepository;
import com.hrajaona.orderandpay.paymentservice.application.port.out.RefundRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RefundPersistenceAdapter implements RefundRepository {
    private final RefundJpaRepository  refundJpaRepository;


    @Override
    public List<RefundJpaEntity> findAll() {
        return refundJpaRepository.findAll();
    }

    @Override
    public Optional<RefundJpaEntity> findById(UUID id) {
        return refundJpaRepository.findById(id);
    }
}
