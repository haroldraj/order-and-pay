package com.hrajaona.orderandpay.paymentservice.application.mapper;

import com.hrajaona.library.events.OrderCreatedEvent;
import com.hrajaona.library.events.PaymentCompletedEvent;
import com.hrajaona.orderandpay.paymentservice.domain.model.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaymentApplicationMapper {

    Payment toDomain(OrderCreatedEvent event);

    @Mapping(source = "id", target = "paymentId")
    PaymentCompletedEvent toPaymentCompletedEvent(Payment payment);
}
