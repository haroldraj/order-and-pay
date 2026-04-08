package com.hrajaona.library.events;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class PaymentEvent {
    private UUID eventId;
    private UUID orderId;
    private UUID paymentId;
    private UUID userId;
    private LocalDateTime valueDate;

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    public PaymentEvent(UUID eventId, UUID orderId, UUID paymentId, UUID userId, LocalDateTime valueDate) {
        this.eventId = eventId;
        this.orderId = orderId;
        this.paymentId = paymentId;
        this.userId = userId;
        this.valueDate = valueDate;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public void setPaymentId(UUID paymentId) {
        this.paymentId = paymentId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setValueDate(LocalDateTime valueDate) {
        this.valueDate = valueDate;
    }

    public UUID getEventId() {
        return eventId;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public UUID getPaymentId() {
        return paymentId;
    }

    public UUID getUserId() {
        return userId;
    }

    public LocalDateTime getValueDate() {
        return valueDate;
    }

    public PaymentEvent() {
    }
}
