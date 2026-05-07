package com.hrajaona.orderandpay.orderservice.domain.model;

import com.hrajaona.library.enums.DeliveryStatus;
import com.hrajaona.library.enums.OrderStatus;
import com.hrajaona.library.enums.PaymentStatus;
import com.hrajaona.library.model.AddressSnapshot;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    private UUID id;
    private UUID userId;
    private UUID addressId;
    private UUID restaurantId;
    private List<OrderItem> orderItems;
    private OrderStatus status;
    private BigDecimal amount;
    private PaymentStatus paymentStatus;
    private DeliveryStatus deliveryStatus;
    private AddressSnapshot addressSnapshot;
    private RestaurantSnapshot restaurantSnapshot;
    private LocalDateTime valueDate;
    private LocalDateTime updatedAt;

    public void markAsPaid() {
        this.status = OrderStatus.PAID;
        this.paymentStatus = PaymentStatus.COMPLETED;
    }

    public void markAsPreparing() {
        this.status = OrderStatus.PREPARING;
    }

    public void markAsPickedUp() {
        this.status = OrderStatus.PICKED_UP;
        this.deliveryStatus = DeliveryStatus.IN_TRANSIT;
    }

    public void markAsDelivered() {
        this.status = OrderStatus.DELIVERED;
        this.deliveryStatus = DeliveryStatus.COMPLETED;
    }
}
