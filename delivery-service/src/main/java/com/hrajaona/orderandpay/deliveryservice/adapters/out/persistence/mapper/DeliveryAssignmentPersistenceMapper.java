package com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.mapper;

import com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.entity.DeliveryAssignmentJpaEntity;
import com.hrajaona.orderandpay.deliveryservice.domain.model.DeliveryAssignment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DeliveryAssignmentPersistenceMapper {

    @Mapping(target = "deliveryId", source = "id.deliveryId")
    @Mapping(target = "driverId", source = "id.driverId")
    DeliveryAssignment toDomain(DeliveryAssignmentJpaEntity deliveryAssignmentJpaEntity);

    @Mapping(target = "id.deliveryId", source = "deliveryId")
    @Mapping(target = "id.driverId", source = "driverId")
    @Mapping(target = "delivery", ignore = true)
    @Mapping(target = "driver", ignore = true)
    DeliveryAssignmentJpaEntity toEntity(DeliveryAssignment deliveryAssignment);
}
