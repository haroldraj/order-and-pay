package com.hrajaona.orderandpay.orderservice.adapters.out.client.restaurant;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemResponseDto {
    private UUID id;
    private String name;
    private String description;
    private Double price;
    private Boolean available;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
