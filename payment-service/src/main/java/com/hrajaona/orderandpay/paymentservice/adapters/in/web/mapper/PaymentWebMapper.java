package com.hrajaona.orderandpay.paymentservice.adapters.in.web.mapper;

import com.hrajaona.orderandpay.paymentservice.adapters.in.web.dto.PaymentRequest;
import com.hrajaona.orderandpay.paymentservice.domain.model.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaymentWebMapper {
    Payment toDomain(PaymentRequest paymentRequest) ;
}
