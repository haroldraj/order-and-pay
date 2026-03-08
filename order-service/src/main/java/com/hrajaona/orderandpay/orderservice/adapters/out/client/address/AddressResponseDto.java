package com.hrajaona.orderandpay.orderservice.adapters.out.client.address;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponseDto {
    private String street;
    private String houseNumber;
    private String city;
    private Integer postalCode;
    private String country;
    private LocalDateTime createdAt;
}
