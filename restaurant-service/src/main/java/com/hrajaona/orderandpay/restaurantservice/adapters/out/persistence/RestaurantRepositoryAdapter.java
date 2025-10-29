package com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence;

import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.mapper.RestaurantPersistenceMapper;
import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.repository.RestaurantRepository;
import com.hrajaona.orderandpay.restaurantservice.application.port.out.RestaurantPort;
import com.hrajaona.orderandpay.restaurantservice.domain.model.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RestaurantRepositoryAdapter implements RestaurantPort {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantPersistenceMapper restaurantPersistenceMapper;

    @Override
    public List<Restaurant> findAllRestaurants() {
        return restaurantRepository.findAll()
                .stream()
                .map(restaurantPersistenceMapper::toDomain)
                .toList();
    }
}
