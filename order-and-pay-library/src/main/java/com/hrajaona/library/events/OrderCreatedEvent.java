package com.hrajaona.library.events;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


public class OrderCreatedEvent extends  OrderEvent {
    private final UUID userId;
    private final String method;
    private final String reference;

    public OrderCreatedEvent(UUID eventId, UUID orderId, BigDecimal amount, LocalDateTime valueDate, UUID userId, String method, String reference) {
        super(eventId, orderId, amount, valueDate);
        this.userId = userId;
        this.method = method;
        this.reference = reference;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getMethod() {
        return method;
    }

    public String getReference() {
        return reference;
    }
}
