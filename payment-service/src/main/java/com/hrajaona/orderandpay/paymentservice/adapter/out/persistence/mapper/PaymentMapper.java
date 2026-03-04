package com.hrajaona.orderandpay.paymentservice.adapter.out.persistence.mapper;

import com.hrajaona.orderandpay.paymentservice.domain.model.Payment;
import com.hrajaona.orderandpay.paymentservice.adapter.out.persistence.entity.PaymentJpaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaymentMapper {
    Payment toDomain(PaymentJpaEntity paymentJpa);
    PaymentJpaEntity toEntity(Payment payment);
}
