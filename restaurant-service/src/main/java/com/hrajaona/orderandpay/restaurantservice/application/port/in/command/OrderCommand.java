package com.hrajaona.orderandpay.restaurantservice.application.port.in.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class OrderCommand {
    private UUID orderId;
    private UUID restaurantId;
}
