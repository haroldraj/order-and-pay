package com.hrajaona.orderandpay.restaurantservice.application.port.in;

import com.hrajaona.orderandpay.restaurantservice.application.port.in.command.PrepareOrderCommand;
import com.hrajaona.orderandpay.restaurantservice.domain.model.RestaurantOrderPreparing;

public interface RestaurantOrderUseCase {
    void markAsPreparing(PrepareOrderCommand command);
}
