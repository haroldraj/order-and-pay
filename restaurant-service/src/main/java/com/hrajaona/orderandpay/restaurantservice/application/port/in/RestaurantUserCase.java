package com.hrajaona.orderandpay.restaurantservice.application.port.in;

import com.hrajaona.orderandpay.restaurantservice.adapters.in.web.dto.RestaurantResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RestaurantUserCase {
    List<RestaurantResponse> loadAllRestaurants();
}
