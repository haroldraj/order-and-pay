package com.hrajaona.orderandpay.paymentservice.infrastructure.persistence.mapper;

import com.hrajaona.orderandpay.paymentservice.domain.model.Refund;
import com.hrajaona.orderandpay.paymentservice.infrastructure.persistence.entity.RefundEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {PaymentMapper.class})
public interface RefundMapper {
    Refund toDomain(RefundEntity refundEntity);
    RefundEntity toEntity(Refund refund);
}
