package com.hrajaona.orderandpay.paymentservice.domain.exception;

import java.util.UUID;

public class PaymentNotFoundException extends  RuntimeException {
    public PaymentNotFoundException(UUID id) {
        super("Payment with id "+id+" not found");
    }
}
