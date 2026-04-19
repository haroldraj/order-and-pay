package com.hrajaona.orderandpay.restaurantservice.application.port.out;

import com.hrajaona.orderandpay.restaurantservice.domain.model.RestaurantOrderStatusHistory;

public interface RestaurantOrderStatusHistoryPort {
    void save(RestaurantOrderStatusHistory orderStatusHistory);
}
