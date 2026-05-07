package com.hrajaona.library.events;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class OrderPickedUpEvent extends OrderEvent {
    private UUID restaurantId;

    public void setRestaurantId(UUID restaurantId) {
        this.restaurantId = restaurantId;
    }

    public UUID getRestaurantId() {
        return restaurantId;
    }

    public OrderPickedUpEvent() {
    }

    public OrderPickedUpEvent(UUID eventId, UUID orderId, BigDecimal amount, LocalDateTime valueDate, UUID restaurantId) {
        super(eventId, orderId, amount, valueDate);
        this.restaurantId = restaurantId;
    }
}
