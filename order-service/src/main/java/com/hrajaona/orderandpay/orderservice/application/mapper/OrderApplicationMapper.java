package com.hrajaona.orderandpay.orderservice.application.mapper;

import com.hrajaona.library.events.OrderPaidEvent;
import com.hrajaona.orderandpay.orderservice.domain.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderApplicationMapper {

    @Mapping(target = "orderId", source = "id")
    @Mapping(target = "deliveryAddress", source = "addressSnapshot")
    @Mapping(target = "items", source = "orderItems")
    OrderPaidEvent toOrderPaidEvent(Order order);

}
