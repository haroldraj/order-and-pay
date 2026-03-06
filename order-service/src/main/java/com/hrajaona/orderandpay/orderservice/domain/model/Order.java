package com.hrajaona.orderandpay.orderservice.domain.model;

import com.hrajaona.library.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private UUID id;
    private UUID userId;
    private UUID addressId;
    private UUID restaurantId;
    private List<OrderItem> orderItems;
    private OrderStatus status;
    private double totalAmount;
    private String paymentStatus;
    private String deliveryStatus;
    private Map<String, Object> addressSnapshot;
    private Map<String, Object> restaurantSnapshot;
    private LocalDateTime valueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
