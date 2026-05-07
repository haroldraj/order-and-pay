package com.hrajaona.orderandpay.deliveryservice.domain.model;

import com.hrajaona.library.enums.DeliveryStatus;
import com.hrajaona.library.model.AddressSnapshot;
import com.hrajaona.library.model.RestaurantSnapshot;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Delivery {
    private UUID id;
    private UUID orderId;
    private UUID restaurantId;
    private RestaurantSnapshot restaurantSnapshot;
    private AddressSnapshot addressSnapshot;
    private DeliveryStatus status;
    private LocalDateTime estimatedDeliveryTime;
    private LocalDateTime deliveredAt;
    private LocalDateTime pickedUpAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
