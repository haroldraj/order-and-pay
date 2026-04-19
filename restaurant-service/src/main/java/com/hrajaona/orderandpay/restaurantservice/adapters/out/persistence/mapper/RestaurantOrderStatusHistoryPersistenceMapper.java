package com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.mapper;

import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.entity.RestaurantOrderStatusHistoryJpaEntity;
import com.hrajaona.orderandpay.restaurantservice.domain.model.RestaurantOrderStatusHistory;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RestaurantOrderStatusHistoryPersistenceMapper {

    RestaurantOrderStatusHistoryJpaEntity toEntity(RestaurantOrderStatusHistory history);

    RestaurantOrderStatusHistory toDomain(RestaurantOrderStatusHistoryJpaEntity historyJpa);
}
