package com.hrajaona.orderandpay.orderservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    private UUID itemIdf;
    private int quantity;
    private double unitPrice;
}
