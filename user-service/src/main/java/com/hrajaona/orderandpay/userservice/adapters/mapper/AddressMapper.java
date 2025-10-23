package com.hrajaona.orderandpay.userservice.adapters.mapper;

import com.hrajaona.orderandpay.userservice.adapters.out.persistence.jpa.AddressJpa;
import com.hrajaona.orderandpay.userservice.domain.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface AddressMapper {
    AddressJpa domainToJpa(Address address);
    Address jpaToDomain(AddressJpa addressJpa);
}
