package com.hrajaona.orderandpay.paymentservice.adapter.in.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public record PaymentRequest(
        @NotNull UUID orderId,
        @NotNull UUID userId,
        @NotNull @Positive double amount,
        @NotBlank String method,
        @NotNull String status,
        @NotBlank String reference) {
}
