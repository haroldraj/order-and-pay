package com.hrajaona.library.events;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


public class OrderCreatedEvent extends OrderEvent {
    private  UUID userId;

    public OrderCreatedEvent(UUID eventId, UUID orderId, BigDecimal amount, LocalDateTime valueDate, UUID userId) {
        super(eventId, orderId, amount, valueDate);
        this.userId = userId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public OrderCreatedEvent() {
    }
}
