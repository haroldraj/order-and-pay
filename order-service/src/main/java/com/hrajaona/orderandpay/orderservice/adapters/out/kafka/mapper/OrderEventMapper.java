package com.hrajaona.orderandpay.orderservice.adapters.out.kafka.mapper;

import com.hrajaona.orderandpay.orderservice.domain.event.OrderCreatedEvent;
import com.hrajaona.orderandpay.orderservice.domain.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderEventMapper {
    //@Mapping(source = "id", target = "orderId")
    OrderCreatedEvent toEvent(Order order);
}
