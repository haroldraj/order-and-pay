package com.hrajaona.orderandpay.restaurantservice.application.mapper;

import com.hrajaona.library.events.OrderPaidEvent;
import com.hrajaona.library.events.OrderPreparingEvent;
import com.hrajaona.library.events.OrderReadyForDeliveryEvent;
import com.hrajaona.orderandpay.restaurantservice.domain.model.RestaurantOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RestaurantOrderApplicationMapper {

    @Mapping(target = "customerSnapshot", source = "customer")
    @Mapping(target = "itemsSnapshot", source = "items")
    RestaurantOrder toDomain(OrderPaidEvent orderPaidEvent);

    @Mapping(target = "customer", source = "customerSnapshot")
    OrderReadyForDeliveryEvent toOrderReadyForDeliveryEvent(RestaurantOrder restaurantOrder);

    OrderPreparingEvent toOrderPreparingEvent(RestaurantOrder restaurantOrder);

}
