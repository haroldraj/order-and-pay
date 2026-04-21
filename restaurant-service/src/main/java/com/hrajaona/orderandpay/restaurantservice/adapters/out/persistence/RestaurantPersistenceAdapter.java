package com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence;

import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.mapper.RestaurantPersistenceMapper;
import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.repository.RestaurantJpaRepository;
import com.hrajaona.orderandpay.restaurantservice.application.port.out.RestaurantRepositoryPort;
import com.hrajaona.orderandpay.restaurantservice.domain.model.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RestaurantPersistenceAdapter implements RestaurantRepositoryPort {
    private final RestaurantJpaRepository restaurantJpaRepository;
    private final RestaurantPersistenceMapper restaurantPersistenceMapper;

    @Override
    public List<Restaurant> findAllRestaurants() {
        return restaurantJpaRepository.findAll()
                .stream()
                .map(restaurantPersistenceMapper::toDomain)
                .toList();
    }

    @Override
    public Restaurant findById(UUID id) {
        return restaurantJpaRepository.findById(id)
                .map(restaurantPersistenceMapper::toDomain)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
    }
}
