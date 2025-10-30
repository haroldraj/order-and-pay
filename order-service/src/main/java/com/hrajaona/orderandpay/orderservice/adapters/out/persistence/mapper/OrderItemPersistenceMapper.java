package com.hrajaona.orderandpay.orderservice.adapters.out.persistence.mapper;

import com.hrajaona.orderandpay.orderservice.adapters.out.persistence.entity.OrderItemJpa;
import com.hrajaona.orderandpay.orderservice.domain.model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderItemPersistenceMapper {
    OrderItemJpa toJpa(OrderItem orderItem);
    OrderItem toDomain(OrderItemJpa orderItemJpa);
}
