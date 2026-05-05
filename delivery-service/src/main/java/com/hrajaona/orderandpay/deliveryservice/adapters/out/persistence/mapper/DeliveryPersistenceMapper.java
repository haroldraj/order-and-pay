package com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.mapper;

import com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.entity.DeliveryJpaEntity;
import com.hrajaona.orderandpay.deliveryservice.domain.model.Delivery;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DeliveryPersistenceMapper {
    Delivery toDomain(DeliveryJpaEntity deliveryJpaEntity);
    DeliveryJpaEntity toEntity(Delivery delivery);
}
