package com.hrajaona.orderandpay.deliveryservice.application.mapper;

import com.hrajaona.library.events.OrderReadyForDeliveryEvent;
import com.hrajaona.orderandpay.deliveryservice.domain.model.Delivery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DeliveryApplicationMapper {

    @Mapping(target = "customer_snapshot", source = "customer")
    @Mapping(target = "address_snapshot", source = "delivery_address")
    Delivery toDomain(OrderReadyForDeliveryEvent orderReadyForDeliveryEvent);
}
