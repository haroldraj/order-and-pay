package com.hrajaona.library.events;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class OrderDeliveredEvent extends OrderEvent {
    private UUID restaurantId;

    public void setRestaurantId(UUID restaurantId) {
        this.restaurantId = restaurantId;
    }

    public UUID getRestaurantId() {
        return restaurantId;
    }

    public OrderDeliveredEvent() {
    }

    public OrderDeliveredEvent(UUID eventId, UUID orderId, BigDecimal amount, LocalDateTime valueDate, UUID restaurantId) {
        super(eventId, orderId, amount, valueDate);
        this.restaurantId = restaurantId;
    }
}
