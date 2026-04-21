package com.hrajaona.orderandpay.restaurantservice.adapters.in.web.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantOrderPreparingDto {
    private UUID orderId;
    private UUID restaurantId;
    private String status;
}
