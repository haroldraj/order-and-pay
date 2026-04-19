package com.hrajaona.orderandpay.restaurantservice.application.port.out;

import com.hrajaona.orderandpay.restaurantservice.domain.model.RestaurantOrder;

public interface RestaurantOrderRepositoryPort {
    void save(RestaurantOrder restaurantOrder);
}
