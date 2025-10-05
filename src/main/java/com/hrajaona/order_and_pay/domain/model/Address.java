package com.hrajaona.order_and_pay.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String street;
    private String house;
    private String box;
    private String city;
    private Integer postalCode;
    private String country;

}
