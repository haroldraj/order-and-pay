package com.hrajaona.orderandpay.orderservice.domain.model;

import com.hrajaona.library.enums.OrderStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderStatusHistory {
    private UUID id;
    private UUID orderId;
    private OrderStatus previousStatus;
    private OrderStatus status;
    private LocalDateTime changedAt;
}
