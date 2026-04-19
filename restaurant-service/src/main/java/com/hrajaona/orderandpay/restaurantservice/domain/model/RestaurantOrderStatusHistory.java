package com.hrajaona.orderandpay.restaurantservice.domain.model;

import com.hrajaona.library.enums.OrderStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantOrderStatusHistory {
    private UUID id;
    private UUID orderId;
    private OrderStatus previousStatus;
    private OrderStatus newStatus;
    private LocalDateTime changedAt;
}
