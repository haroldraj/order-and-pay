package com.hrajaona.orderandpay.orderservice.adapters.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemRequest {
    private UUID productId;
    private String productName;
    private Integer quantity;
    private BigDecimal unitPrice;
}
