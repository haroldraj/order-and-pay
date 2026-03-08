package com.hrajaona.orderandpay.orderservice.adapters.out.client.mapper;

import com.hrajaona.orderandpay.orderservice.adapters.out.client.restaurant.RestaurantResponseDto;
import com.hrajaona.orderandpay.orderservice.domain.model.RestaurantSnapshot;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RestaurantClientMapper {
    RestaurantSnapshot toDomain(RestaurantResponseDto restaurantResponseDto);
}
