package com.hrajaona.order_and_pay.adapters.out.mapper;

import com.hrajaona.order_and_pay.domain.model.Address;
import com.hrajaona.order_and_pay.shared.adapters.out.persistence.embeddable.AddressEmbeddable;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public AddressEmbeddable toJpa(Address address) {
        return new AddressEmbeddable(
                address.getStreet(),
                address.getHouse(),
                address.getBox(),
                address.getCity(),
                address.getPostalCode(),
                address.getCountry());
    }

    public Address toDomain(AddressEmbeddable addressEmbeddable) {
        return new Address(
                addressEmbeddable.getStreet(),
                addressEmbeddable.getHouse(),
                addressEmbeddable.getBox(),
                addressEmbeddable.getCity(),
                addressEmbeddable.getPostalCode(),
                addressEmbeddable.getCountry()
        );
    }
}
