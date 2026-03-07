package com.hrajaona.orderandpay.orderservice.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantSnapshot {
    private String name;
    private String address;
    private String phoneNumber;
    private String emailAddress;
    private LocalDateTime createdAt;
}
