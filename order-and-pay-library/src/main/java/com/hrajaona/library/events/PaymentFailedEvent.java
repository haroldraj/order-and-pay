package com.hrajaona.library.events;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentFailedEvent extends  PaymentEvent{
    private String reason;

    public PaymentFailedEvent() {
    }

    public PaymentFailedEvent(UUID eventId, UUID orderId, UUID paymentId, UUID userId, LocalDateTime valueDate, String reason) {
        super(eventId, orderId, paymentId, userId, valueDate);
        this.reason = reason;
    }

    public PaymentFailedEvent(String reason) {
        this.reason = reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
}
