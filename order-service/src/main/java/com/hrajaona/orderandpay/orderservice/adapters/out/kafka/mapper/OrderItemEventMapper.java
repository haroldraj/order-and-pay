package com.hrajaona.orderandpay.orderservice.adapters.out.kafka.mapper;

import com.hrajaona.orderandpay.orderservice.domain.event.OrderItemEvent;
import com.hrajaona.orderandpay.orderservice.domain.model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderItemEventMapper {
    OrderItemEvent toEvent(OrderItem orderItem);
}
