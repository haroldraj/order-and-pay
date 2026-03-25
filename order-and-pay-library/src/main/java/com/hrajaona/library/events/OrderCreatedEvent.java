package com.hrajaona.library.events;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


public class OrderCreatedEvent {
    private UUID orderId;
    private UUID userId;
    private UUID restaurantId;
    private UUID addressId;
    private BigDecimal totalAmount;
    private LocalDateTime valueDate;
    private List<OrderItemEvent> orderItems;

    public OrderCreatedEvent(UUID orderId, UUID userId, UUID restaurantId, UUID addressId, BigDecimal totalAmount, LocalDateTime valueDate, List<OrderItemEvent> orderItems) {
        this.orderId = orderId;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.addressId = addressId;
        this.totalAmount = totalAmount;
        this.valueDate = valueDate;
        this.orderItems = orderItems;
    }

    public UUID getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(UUID restaurantId) {
        this.restaurantId = restaurantId;
    }

    public UUID getAddressId() {
        return addressId;
    }

    public void setAddressId(UUID addressId) {
        this.addressId = addressId;
    }

    public List<OrderItemEvent> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemEvent> orderItems) {
        this.orderItems = orderItems;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getValueDate() {
        return valueDate;
    }

    public void setValueDate(LocalDateTime valueDate) {
        this.valueDate = valueDate;
    }

    public OrderCreatedEvent() {
    }
}
