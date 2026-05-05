package com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.mapper;

import com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.entity.DriverJpaEntity;
import com.hrajaona.orderandpay.deliveryservice.domain.model.Driver;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DriverPersistenceMapper {
    Driver toDomain(DriverJpaEntity driverJpaEntity);
    DriverJpaEntity toEntity(Driver driver);
}
