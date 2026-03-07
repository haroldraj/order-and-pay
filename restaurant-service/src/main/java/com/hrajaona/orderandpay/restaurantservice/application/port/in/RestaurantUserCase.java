package com.hrajaona.orderandpay.restaurantservice.application.port.in;

import com.hrajaona.orderandpay.restaurantservice.adapters.in.web.dto.RestaurantResponse;
import com.hrajaona.orderandpay.restaurantservice.domain.model.Restaurant;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface RestaurantUserCase {
    List<RestaurantResponse> loadAllRestaurants();
    Restaurant getRestaurantById(UUID id);
}
