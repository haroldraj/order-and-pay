package com.hrajaona.orderandpay.paymentservice.adapter.out.persistence.mapper;

import com.hrajaona.orderandpay.paymentservice.domain.model.Refund;
import com.hrajaona.orderandpay.paymentservice.adapter.out.persistence.entity.RefundJpaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {PaymentMapper.class})
public interface RefundMapper {
    Refund toDomain(RefundJpaEntity refundJpaEntity);
    RefundJpaEntity toEntity(Refund refund);
}
