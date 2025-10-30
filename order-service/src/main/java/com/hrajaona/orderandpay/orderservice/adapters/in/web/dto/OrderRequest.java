package com.hrajaona.orderandpay.orderservice.adapters.in.web.dto;

import com.hrajaona.orderandpay.orderservice.domain.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private UUID userIdf;
    private UUID addressIdf;
    private UUID restaurantIdf;
    private List<OrderItem> orderItems;
    private String status;
    private double totalAmount;
    private String paymentStatus;
    private String deliveryStatus;
    private LocalDateTime orderDate;
}
