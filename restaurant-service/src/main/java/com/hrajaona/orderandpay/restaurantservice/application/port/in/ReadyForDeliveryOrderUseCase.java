package com.hrajaona.orderandpay.restaurantservice.application.port.in;

import com.hrajaona.orderandpay.restaurantservice.application.port.in.command.OrderCommand;
import com.hrajaona.orderandpay.restaurantservice.application.port.in.command.ReadyForDeliveryOrderCommand;

public interface ReadyForDeliveryOrderUseCase {
    void execute(OrderCommand command);
}
