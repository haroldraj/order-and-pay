package com.hrajaona.orderandpay.restaurantservice.domain.model;

import com.hrajaona.library.enums.OrderStatus;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantOrderPreparing {
    private UUID orderId;
    private UUID restaurantId;
    private OrderStatus status;

    void validateStatus() {
        if (!this.status.equals(OrderStatus.PREPARING)) {
            throw new RuntimeException("Status not valid");
        }
    }
}
