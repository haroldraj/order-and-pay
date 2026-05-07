package com.hrajaona.orderandpay.restaurantservice.domain.mapper;

import com.hrajaona.library.model.RestaurantSnapshot;
import com.hrajaona.orderandpay.restaurantservice.domain.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RestaurantSnapshotMapper {

    RestaurantSnapshot toSnapshot(Restaurant restaurant);
}
