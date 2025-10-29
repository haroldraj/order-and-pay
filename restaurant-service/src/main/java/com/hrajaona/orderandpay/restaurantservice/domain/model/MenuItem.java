package com.hrajaona.orderandpay.restaurantservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem {
    private UUID itemIdf;
    private String name;
    private String description;
    private Double price;
    private Boolean available;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
