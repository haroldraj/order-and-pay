package com.hrajaona.orderandpay.userservice.adapters.out.persistence.mapper;

import com.hrajaona.orderandpay.userservice.adapters.out.persistence.entity.AddressJpaEntity;
import com.hrajaona.orderandpay.userservice.domain.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressPersistenceMapper {

    AddressJpaEntity toJpa(Address address);
    Address toDomain(AddressJpaEntity addressJpaEntity);
}
