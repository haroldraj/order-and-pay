package com.hrajaona.library.events;

import com.hrajaona.library.enums.PaymentStatus;

import java.math.BigDecimal;

public class PaymentCompletedEvent extends PaymentEvent {
    private BigDecimal amount;
    private String method;
    private PaymentStatus status;
    private String reference;

}
