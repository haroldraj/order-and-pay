package com.hrajaona.orderandpay.orderservice.adapters.out.persistence;

import com.hrajaona.orderandpay.orderservice.adapters.out.persistence.mapper.OrderStatusHistoryMapper;
import com.hrajaona.orderandpay.orderservice.adapters.out.persistence.repository.OrderStatusHistoryJpaRepository;
import com.hrajaona.orderandpay.orderservice.application.port.out.OrderStatusHistoryRepositoryPort;
import com.hrajaona.orderandpay.orderservice.domain.model.OrderStatusHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class OrderStatusHistoryPersistenceAdapter implements OrderStatusHistoryRepositoryPort {
    private final OrderStatusHistoryMapper orderStatusHistoryMapper;
    private final OrderStatusHistoryJpaRepository orderStatusHistoryJpaRepository;

    @Override
    public void save(OrderStatusHistory orderStatusHistory) {
        try {
            orderStatusHistory.setId(UUID.randomUUID());
            orderStatusHistoryJpaRepository.save(orderStatusHistoryMapper.toEntity(orderStatusHistory));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
