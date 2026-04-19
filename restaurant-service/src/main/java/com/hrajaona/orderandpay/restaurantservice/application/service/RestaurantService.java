package com.hrajaona.orderandpay.restaurantservice.application.service;

import com.hrajaona.orderandpay.restaurantservice.adapters.in.web.dto.RestaurantResponse;
import com.hrajaona.orderandpay.restaurantservice.adapters.in.web.mapper.RestaurantWebMapper;
import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.RestaurantPersistenceAdapter;
import com.hrajaona.orderandpay.restaurantservice.application.port.in.RestaurantUserCase;
import com.hrajaona.orderandpay.restaurantservice.domain.model.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Component
@RequiredArgsConstructor
public class RestaurantService implements RestaurantUserCase {
    private final RestaurantWebMapper restaurantWebMapper;
    private final RestaurantPersistenceAdapter restaurantPersistenceAdapter;

    @Override
    public List<RestaurantResponse> loadAllRestaurants() {
        return restaurantPersistenceAdapter.findAllRestaurants()
                .stream()
                .map(restaurantWebMapper::toResponse)
                .toList();
    }

    @Override
    public Restaurant getRestaurantById(UUID id) {
        return restaurantPersistenceAdapter.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with id" + id));
    }
}
