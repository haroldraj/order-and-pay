package com.hrajaona.order_and_pay.shared.adapters.out.persistence.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class OrderAddressSnapshot {

    @Column(name = "ship_name")
    private String name;

    @Column(name = "ship_phone")
    private String phone;

    @Column(name = "ship_street")
    private String street;

    @Column(name = "ship_house")
    private String house;

    @Column(name = "ship_box")
    private String box;

    @Column(name = "ship_city")
    private String city;

    @Column(name = "ship_postal_code")
    private Integer postalCode;

    @Column(name = "ship_country")
    private String country;

}
