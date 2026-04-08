package com.hrajaona.orderandpay.paymentservice.adapters.in.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentRequest(
        @NotNull UUID orderId,
        @NotNull UUID userId,
        @NotNull @Positive BigDecimal amount,
        @NotBlank String method,
        @NotNull String status,
        @NotBlank String reference) {
}
