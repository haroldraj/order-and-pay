package com.hrajaona.order_and_pay.shared.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    PENDING("Waiting for processing"),
    ON_GOING("Currently being processed"),
    PROCESSED("Validated and queued"),
    COMPLETED("Successfully completed"),
    CANCELLED("Cancelled by user or restaurant"),
    FAILED("Failed due to error");

    private final String description;

}
