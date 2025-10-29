package com.hrajaona.orderandpay.restaurantservice.adapters.in.web.mapper;

import com.hrajaona.orderandpay.restaurantservice.adapters.in.web.dto.RestaurantResponse;
import com.hrajaona.orderandpay.restaurantservice.domain.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RestaurantWebMapper {
    RestaurantResponse toResponse(Restaurant restaurant);
}
