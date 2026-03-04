package com.hrajaona.orderandpay.paymentservice.infrastructure.persistence.mapper;

import com.hrajaona.orderandpay.paymentservice.domain.model.Payment;
import com.hrajaona.orderandpay.paymentservice.infrastructure.persistence.entity.PaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaymentMapper {
    Payment toDomain(PaymentEntity paymentEntity);
    PaymentEntity toEntity(Payment payment);
}
