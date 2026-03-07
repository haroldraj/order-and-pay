package com.hrajaona.orderandpay.orderservice.domain.model;

import com.hrajaona.library.enums.DeliveryStatus;
import com.hrajaona.library.enums.OrderStatus;
import com.hrajaona.library.enums.PaymentStatus;
import lombok.*;

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
    private double totalAmount;
    private PaymentStatus paymentStatus;
    private DeliveryStatus deliveryStatus;
    private AddressSnapshot addressSnapshot;
    private RestaurantSnapshot restaurantSnapshot;
    private LocalDateTime valueDate;
    private LocalDateTime updatedAt;
}
