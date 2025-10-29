package com.hrajaona.orderandpay.restaurantservice.domain.model;

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
public class Restaurant {
    private UUID restaurantIdf;
    private String name;
    private String address;
    private List<MenuItem> menuItems;
    private String phoneNumber;
    private String emailAddress;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
