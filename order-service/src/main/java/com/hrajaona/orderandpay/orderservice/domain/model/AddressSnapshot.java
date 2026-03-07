package com.hrajaona.orderandpay.orderservice.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressSnapshot {
    private String street;
    private String houseNumber;
    private String city;
    private Integer postalCode;
    private String country;
    private LocalDateTime createdAt;
}
