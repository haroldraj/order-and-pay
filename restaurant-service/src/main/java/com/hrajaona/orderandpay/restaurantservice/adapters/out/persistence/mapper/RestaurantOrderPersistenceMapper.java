package com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.mapper;

import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.entity.RestaurantOrderJpaEntity;
import com.hrajaona.orderandpay.restaurantservice.domain.model.RestaurantOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RestaurantOrderPersistenceMapper {

    @Mapping(target = "restaurantId", source = "restaurant.id")
    RestaurantOrder toDomain(RestaurantOrderJpaEntity restaurantOrderJpa);

    @Mapping(target = "restaurant", ignore = true)
    RestaurantOrderJpaEntity toEntity(RestaurantOrder restaurantOrder);
}
