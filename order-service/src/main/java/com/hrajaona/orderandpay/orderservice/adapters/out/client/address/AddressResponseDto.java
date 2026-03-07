package com.hrajaona.orderandpay.orderservice.adapters.out.client.address;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponseDto {
    private UUID id;
    private String label;
    private String street;
    private String houseNumber;
    private String city;
    private Integer postalCode;
    private String country;
    private Boolean isDefault;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
