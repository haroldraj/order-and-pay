package com.hrajaona.orderandpay.restaurantservice.application.port.in.command;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ReadyForDeliveryOrderCommand extends OrderCommand{
    public ReadyForDeliveryOrderCommand(UUID orderId, UUID restaurantId) {
        super(orderId, restaurantId);
    }
}
