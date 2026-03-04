package com.hrajaona.orderandpay.paymentservice.application.port.in;

import com.hrajaona.orderandpay.paymentservice.domain.model.Payment;

import java.util.Optional;

public interface GetPaymentUseCase {
    Payment getPayment(Long id);
}
