package com.hrajaona.order_and_pay.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderAddress extends Address {
    private String name;
    private String phone;

}
