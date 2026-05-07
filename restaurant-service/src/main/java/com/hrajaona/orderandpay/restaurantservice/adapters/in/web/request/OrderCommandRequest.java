package com.hrajaona.orderandpay.restaurantservice.adapters.in.web.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderCommandRequest {
    private UUID orderId;
    private UUID restaurantId;
}
