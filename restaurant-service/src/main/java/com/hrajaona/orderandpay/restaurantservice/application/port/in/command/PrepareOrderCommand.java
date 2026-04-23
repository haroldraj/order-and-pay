package com.hrajaona.orderandpay.restaurantservice.application.port.in.command;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PrepareOrderCommand extends OrderCommand {
    public PrepareOrderCommand(UUID orderId, UUID restaurantId) {
        super(orderId, restaurantId);
    }
}
