package com.hrajaona.orderandpay.restaurantservice.domain.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuItem {
    private UUID id;
    private String name;
    private String description;
    private Double price;
    private Boolean available;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
