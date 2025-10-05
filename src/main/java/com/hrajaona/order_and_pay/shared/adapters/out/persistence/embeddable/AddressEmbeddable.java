package com.hrajaona.order_and_pay.shared.adapters.out.persistence.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressEmbeddable {

    @Column(name = "addr_street")
    private String street;

    @Column(name = "addr_house")
    private String house;

    @Column(name = "addr_box")
    private String box;

    @Column(name = "addr_city")
    private String city;

    @Column(name = "addr_postal_code")
    private Integer postalCode;

    @Column(name = "addr_country")
    private String country;

}
