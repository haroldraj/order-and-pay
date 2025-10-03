package com.hrajaona.order_and_pay.shared.adapters.out.persistence.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class AddressEmbeddable {

    @Column(name = "addr_street")
    private String street;

    @Column(name = "addr_house")
    private String house;

    @Column(name = "box")
    private String box;

    @Column(name = "city")
    private String city;

    @Column(name = "postal_code")
    private Integer postalCode;

    @Column(name = "country")
    private String country;

}
