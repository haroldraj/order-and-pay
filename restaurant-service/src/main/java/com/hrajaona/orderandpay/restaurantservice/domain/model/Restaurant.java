package com.hrajaona.orderandpay.restaurantservice.domain.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Restaurant {
    private UUID id;
    private String name;
    private String address;
    private List<MenuItem> menuItems;
    private List<RestaurantOrder> restaurantOrders;
    private String phoneNumber;
    private String emailAddress;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
