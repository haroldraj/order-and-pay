package com.hrajaona.orderandpay.restaurantservice.application.port.out;

import com.hrajaona.library.enums.OrderStatus;
import com.hrajaona.orderandpay.restaurantservice.domain.model.RestaurantOrder;

import java.util.UUID;

public interface RestaurantOrderRepositoryPort {
    void save(RestaurantOrder restaurantOrder);
    RestaurantOrder findByOrderIdAndRestaurantId(UUID orderId, UUID restaurantId);
//    RestaurantOrder updateStatus(UUID orderId, UUID restaurantId, OrderStatus status);
    void updateStatus(RestaurantOrder order);
}
