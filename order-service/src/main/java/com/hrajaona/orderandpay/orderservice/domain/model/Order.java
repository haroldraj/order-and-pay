package com.hrajaona.orderandpay.orderservice.domain.model;

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
    private UUID orderIdf;
    private UUID userIdf;
    private UUID addressIdf;
    private UUID restaurantIdf;
    private List<OrderItem> orderItems;
    private String status;
    private double totalAmount;
    private String paymentStatus;
    private String deliveryStatus;
    private Map<String, Object> addressSnapshot;
    private Map<String, Object> restaurantSnapshot;
    private LocalDateTime orderDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
