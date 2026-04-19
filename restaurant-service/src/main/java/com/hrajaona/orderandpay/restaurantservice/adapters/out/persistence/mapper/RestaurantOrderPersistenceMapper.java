package com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.mapper;

import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.entity.RestaurantOrderJpaEntity;
import com.hrajaona.orderandpay.restaurantservice.domain.model.RestaurantOrder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RestaurantOrderPersistenceMapper {

    RestaurantOrder toDomain(RestaurantOrderJpaEntity restaurantOrderJpa);

    RestaurantOrderJpaEntity toEntity(RestaurantOrder restaurantOrder);
}
