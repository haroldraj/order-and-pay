package com.hrajaona.orderandpay.restaurantservice.application.port.in;

import com.hrajaona.orderandpay.restaurantservice.application.port.in.command.PrepareOrderCommand;

public interface PrepareOrderUseCase {
    void execute(PrepareOrderCommand command);
}
