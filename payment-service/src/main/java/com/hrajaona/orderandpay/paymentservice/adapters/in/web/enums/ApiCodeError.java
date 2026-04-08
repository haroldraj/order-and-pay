package com.hrajaona.orderandpay.paymentservice.adapters.in.web.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ApiCodeError {
    INVALID_ID("Invalid UUID format"),
    BAD_REQUEST("Invalid request parameters"),
    NOT_FOUND("Element not found"),
    INTERNAL_ERROR("Unexpected error");

    private final String value;


}
