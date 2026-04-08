package com.hrajaona.library.events;

import com.hrajaona.library.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentCompletedEvent extends PaymentEvent {
    private BigDecimal amount;
    private String method;
    private PaymentStatus status;
    private String reference;

    public BigDecimal getAmount() {
        return amount;
    }

    public String getMethod() {
        return method;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public String getReference() {
        return reference;
    }

    public PaymentCompletedEvent(UUID eventId, UUID orderId, UUID paymentId, UUID userId, LocalDateTime valueDate, BigDecimal amount, String method, PaymentStatus status, String reference) {
        super(eventId, orderId, paymentId, userId, valueDate);
        this.amount = amount;
        this.method = method;
        this.status = status;
        this.reference = reference;
    }

    public PaymentCompletedEvent() {
    }
}
