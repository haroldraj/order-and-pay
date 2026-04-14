package com.hrajaona.library.events;

import com.hrajaona.library.model.AddressSnapshot;
import com.hrajaona.library.model.CustomerSnapshot;
import com.hrajaona.library.model.OrderItemPayload;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class OrderPaidEvent extends OrderEvent {
    private UUID restaurantId;
    private CustomerSnapshot customer;
    private AddressSnapshot deliveryAddress;
    private List<OrderItemPayload> items;

    public OrderPaidEvent() {
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setItems(List<OrderItemPayload> items) {
        this.items = items;
    }

    public void setDeliveryAddress(AddressSnapshot deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setCustomer(CustomerSnapshot customer) {
        this.customer = customer;
    }

    public void setRestaurantId(UUID restaurantId) {
        this.restaurantId = restaurantId;
    }

    private String note;

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
