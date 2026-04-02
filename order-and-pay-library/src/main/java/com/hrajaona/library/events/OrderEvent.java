package com.hrajaona.library.events;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public abstract class OrderEvent {
    private final UUID eventId;
    private final UUID orderId;
    private final BigDecimal amount;
    private final LocalDateTime valueDate;


    public UUID getEventId() {
        return eventId;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getValueDate() {
        return valueDate;
    }

    public OrderEvent(UUID eventId, UUID orderId, BigDecimal amount, LocalDateTime valueDate) {
        this.eventId = eventId;
        this.orderId = orderId;
        this.amount = amount;
        this.valueDate = valueDate;
    }
}
