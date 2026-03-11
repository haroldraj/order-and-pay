package com.hrajaona.orderandpay.orderservice.adapters.out.persistence.mapper;

import com.hrajaona.orderandpay.orderservice.adapters.out.persistence.entity.OrderItemJpaEntity;
import com.hrajaona.orderandpay.orderservice.domain.model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderItemPersistenceMapper {
    OrderItemJpaEntity toEntity(OrderItem orderItem);
    OrderItem toDomain(OrderItemJpaEntity orderItemJpa);
    List<OrderItemJpaEntity> toEntities(List<OrderItem> orderItems);
}
