package com.hrajaona.orderandpay.restaurantservice.domain.model;

import com.hrajaona.library.enums.OrderStatus;
import com.hrajaona.library.model.CustomerSnapshot;
import com.hrajaona.library.model.OrderItemPayload;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantOrder {
    private UUID id;
    private UUID orderId;
    private UUID restaurantId;
    private OrderStatus status;
    private BigDecimal amount;
    private List<OrderItemPayload> itemsSnapshot;
    private CustomerSnapshot customerSnapshot;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

