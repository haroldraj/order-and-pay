package com.hrajaona.orderandpay.restaurantservice.adapters.in.web.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class OrderCommandRequest {
    private UUID orderId;
    private UUID restaurantId;
}
