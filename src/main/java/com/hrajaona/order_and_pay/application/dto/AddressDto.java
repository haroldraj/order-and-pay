package com.hrajaona.order_and_pay.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private String street;
    private String house;
    private String box;
    private String city;
    private Integer postalCode;
    private String country;
}
