package com.hrajaona.orderandpay.paymentservice.adapters.in.kafka;

import com.hrajaona.library.events.OrderCreatedEvent;
import com.hrajaona.library.events.PaymentCompletedEvent;
import com.hrajaona.orderandpay.paymentservice.domain.model.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaymentEventMapper {
    PaymentCompletedEvent toCompletedEvent(Payment payment);
    Payment toDomain(OrderCreatedEvent orderCreatedEvent);
}
