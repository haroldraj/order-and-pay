package com.hrajaona.orderandpay.orderservice.adapters.in.web.mapper;

import com.hrajaona.orderandpay.orderservice.adapters.in.web.dto.OrderItemRequest;
import com.hrajaona.orderandpay.orderservice.domain.model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderItemWebMapper {
    OrderItem toDomain(OrderItemRequest orderItemRequest);
    List<OrderItem> toDomainList(List<OrderItemRequest> orderItemRequestList);
}
