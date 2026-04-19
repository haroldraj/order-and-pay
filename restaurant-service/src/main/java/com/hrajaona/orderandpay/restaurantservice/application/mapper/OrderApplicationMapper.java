package com.hrajaona.orderandpay.restaurantservice.application.mapper;

import com.hrajaona.library.events.OrderPaidEvent;
import com.hrajaona.library.events.OrderReadyForDeliveryEvent;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderApplicationMapper {

    OrderReadyForDeliveryEvent toOrderReadyForDelivery(OrderPaidEvent order);
}
