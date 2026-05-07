package com.hrajaona.orderandpay.restaurantservice.domain.exception;

import java.util.UUID;

public class RestaurantOrderStatusHistoryNotSavedException extends RuntimeException{
    public RestaurantOrderStatusHistoryNotSavedException(UUID orderId) {
        super("Cannot save RestaurantOrderStatusHistory with orderId = " + orderId);
    }
}
