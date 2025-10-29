package com.hrajaona.orderandpay.restaurantservice.application.port.service;

import com.hrajaona.orderandpay.restaurantservice.adapters.in.web.dto.RestaurantResponse;
import com.hrajaona.orderandpay.restaurantservice.adapters.in.web.mapper.RestaurantWebMapper;
import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.RestaurantRepositoryAdapter;
import com.hrajaona.orderandpay.restaurantservice.application.port.in.RestaurantUserCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantUserCase {
    private final RestaurantWebMapper restaurantWebMapper;
    private final RestaurantRepositoryAdapter restaurantRepositoryAdapter;

    @Override
    public List<RestaurantResponse> loadAllRestaurants() {
        return restaurantRepositoryAdapter.findAllRestaurants()
                .stream()
                .map(restaurantWebMapper::toResponse)
                .toList();
    }
}
