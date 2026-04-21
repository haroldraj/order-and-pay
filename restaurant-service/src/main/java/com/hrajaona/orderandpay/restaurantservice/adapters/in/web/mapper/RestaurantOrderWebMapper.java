package com.hrajaona.orderandpay.restaurantservice.adapters.in.web.mapper;

import com.hrajaona.orderandpay.restaurantservice.adapters.in.web.dto.RestaurantOrderPreparingDto;
import com.hrajaona.orderandpay.restaurantservice.domain.model.RestaurantOrderPreparing;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RestaurantOrderWebMapper {
    RestaurantOrderPreparing toDomain(RestaurantOrderPreparingDto orderPreparingDto);
}
