package com.hrajaona.orderandpay.orderservice.adapters.out.persistence.mapper;

import com.hrajaona.orderandpay.orderservice.adapters.out.persistence.entity.OrderStatusHistoryJpaEntity;
import com.hrajaona.orderandpay.orderservice.domain.model.OrderStatusHistory;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderStatusHistoryMapper {
    OrderStatusHistory toDomain(OrderStatusHistoryJpaEntity orderStatusHistoryJpaEntity);
    OrderStatusHistoryJpaEntity toEntity(OrderStatusHistory orderStatusHistory);
}
