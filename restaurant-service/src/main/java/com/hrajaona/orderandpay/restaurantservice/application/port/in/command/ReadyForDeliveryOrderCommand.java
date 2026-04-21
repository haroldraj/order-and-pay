package com.hrajaona.orderandpay.restaurantservice.application.port.in.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class ReadyForDeliveryOrderCommand {
    private UUID orderId;
    private UUID restaurantId;
}
