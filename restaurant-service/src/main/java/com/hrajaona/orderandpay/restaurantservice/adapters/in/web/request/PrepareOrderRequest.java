package com.hrajaona.orderandpay.restaurantservice.adapters.in.web.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class PrepareOrderRequest {
    private UUID orderId;
    private UUID restaurantId;
}
