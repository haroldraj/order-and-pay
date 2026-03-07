package com.hrajaona.orderandpay.orderservice.adapters.out.client.mapper;

import com.hrajaona.orderandpay.orderservice.adapters.out.client.address.AddressResponseDto;
import com.hrajaona.orderandpay.orderservice.domain.model.AddressSnapshot;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressClientMapper {
    AddressSnapshot toDomain(AddressResponseDto addressResponseDto);
}
