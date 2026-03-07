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
    private UUID userId;
    private UUID addressId;
    private UUID restaurantId;
    private List<OrderItem> orderItems;
    private double totalAmount;
}
