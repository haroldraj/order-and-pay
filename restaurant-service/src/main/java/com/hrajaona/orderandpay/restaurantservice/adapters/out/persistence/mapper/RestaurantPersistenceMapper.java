package com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.mapper;

import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.entity.RestaurantJpa;
import com.hrajaona.orderandpay.restaurantservice.domain.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RestaurantPersistenceMapper {
    RestaurantJpa toJpa(Restaurant restaurant);
    Restaurant toDomain(RestaurantJpa restaurantJpa);
}
