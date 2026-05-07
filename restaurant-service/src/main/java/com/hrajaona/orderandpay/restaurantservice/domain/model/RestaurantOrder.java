package com.hrajaona.orderandpay.restaurantservice.domain.model;

import com.hrajaona.library.enums.OrderStatus;
import com.hrajaona.library.model.AddressSnapshot;
import com.hrajaona.library.model.CustomerSnapshot;
import com.hrajaona.library.model.OrderItemPayload;
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
public class RestaurantOrder {
    private UUID id;
    private UUID orderId;
    private UUID restaurantId;
    private OrderStatus status;
    private BigDecimal amount;
    private String correlationId;
    private List<OrderItemPayload> itemsSnapshot;
    private CustomerSnapshot customerSnapshot;
    private AddressSnapshot deliveryAddress;
    private LocalDateTime valueDate;
    private LocalDateTime updatedAt;

    public void markAsPaid() {
        this.status = OrderStatus.PAID;
    }

    public void markAsPreparing() {
        this.status = OrderStatus.PREPARING;
    }

    public void markAsDelivered() {
        this.status = OrderStatus.DELIVERED;
    }

    public void markAsInDelivery() {
        this.status = OrderStatus.IN_DELIVERY;
    }

    public void markAsReadyForDelivery() {
        this.status = OrderStatus.READY_FOR_DELIVERY;
    }
}

