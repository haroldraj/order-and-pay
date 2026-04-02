package com.hrajaona.library.events;

import com.hrajaona.library.model.AddressSnapshot;
import com.hrajaona.library.model.CustomerSnapshot;
import com.hrajaona.library.model.OrderItemPayload;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class OrderPaidEvent extends OrderEvent {
    private final UUID restaurantId;
    private final CustomerSnapshot customer;
    private final AddressSnapshot deliveryAddress;
    private final List<OrderItemPayload> items;
    private final String note;

    public UUID getRestaurantId() {
        return restaurantId;
    }

    public CustomerSnapshot getCustomer() {
        return customer;
    }

    public AddressSnapshot getDeliveryAddress() {
        return deliveryAddress;
    }

    public List<OrderItemPayload> getItems() {
        return items;
    }

    public String getNote() {
        return note;
    }

    public OrderPaidEvent(UUID eventId, UUID orderId, BigDecimal amount, LocalDateTime valueDate, UUID restaurantId, CustomerSnapshot customer, AddressSnapshot deliveryAddress, List<OrderItemPayload> items, String note) {
        super(eventId, orderId, amount, valueDate);
        this.restaurantId = restaurantId;
        this.customer = customer;
        this.deliveryAddress = deliveryAddress;
        this.items = items;
        this.note = note;
    }
}
