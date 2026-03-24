package com.hrajaona.orderandpay.orderservice.domain.event;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class OrderCreatedEvent {
    private UUID id;
    private UUID userId;
    private UUID restaurantId;
    private UUID addressId;
    private List<OrderItemEvent> orderItems;
    private double totalAmount;
    private LocalDateTime valueDate;
}
