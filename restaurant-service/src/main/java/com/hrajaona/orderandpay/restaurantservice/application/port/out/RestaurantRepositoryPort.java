package com.hrajaona.orderandpay.restaurantservice.application.port.out;

import com.hrajaona.orderandpay.restaurantservice.domain.model.Restaurant;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface RestaurantRepositoryPort {
    List<Restaurant> findAllRestaurants();
    Restaurant findById(UUID id);
}
