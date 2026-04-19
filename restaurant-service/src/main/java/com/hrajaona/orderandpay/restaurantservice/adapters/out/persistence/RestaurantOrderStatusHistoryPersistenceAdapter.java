package com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence;

import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.mapper.RestaurantOrderStatusHistoryPersistenceMapper;
import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.repository.RestaurantOrderStatusHistoryJpaRepository;
import com.hrajaona.orderandpay.restaurantservice.application.port.out.RestaurantOrderStatusHistoryPort;
import com.hrajaona.orderandpay.restaurantservice.domain.model.RestaurantOrderStatusHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RestaurantOrderStatusHistoryPersistenceAdapter implements RestaurantOrderStatusHistoryPort {
    private final RestaurantOrderStatusHistoryJpaRepository repository;
    private final RestaurantOrderStatusHistoryPersistenceMapper mapper;

    @Override
    public void save(RestaurantOrderStatusHistory orderStatusHistory) {
        orderStatusHistory.setId(UUID.randomUUID());

        try {
            repository.save(mapper.toEntity(orderStatusHistory));
        } catch (Exception e) {
            throw new RuntimeException("Cannot save RestaurantOrderStatusHistory :" + e);
        }

    }
}
