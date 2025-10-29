package com.hrajaona.orderandpay.restaurantservice.application.port.out;

import com.hrajaona.orderandpay.restaurantservice.domain.model.Restaurant;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RestaurantPort {
    List<Restaurant> findAllRestaurants();
}
