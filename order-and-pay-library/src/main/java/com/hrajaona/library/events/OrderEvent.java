package com.hrajaona.library.events;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public abstract class OrderEvent {
    private UUID eventId;
    private UUID orderId;
    private BigDecimal amount;
    private LocalDateTime valueDate;

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    public UUID getEventId() {
        return eventId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setValueDate(LocalDateTime valueDate) {
        this.valueDate = valueDate;
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

    public OrderEvent() {
    }
}
