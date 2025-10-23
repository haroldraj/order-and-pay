package com.hrajaona.user_service.adapters.mapper;

import com.hrajaona.user_service.adapters.out.persistence.jpa.AddressJpa;
import com.hrajaona.user_service.domain.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface AddressMapper {
    AddressJpa domainToJpa(Address address);
    Address jpaToDomain(AddressJpa addressJpa);
}
