package com.hrajaona.orderandpay.orderservice.adapters.out.persistence.mapper;

import com.hrajaona.orderandpay.orderservice.adapters.out.persistence.entity.OrderJpa;
import com.hrajaona.orderandpay.orderservice.domain.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderPersistenceMapper {
    OrderJpa toJpa(Order order);
    Order toDomain(OrderJpa orderJpa);
}
