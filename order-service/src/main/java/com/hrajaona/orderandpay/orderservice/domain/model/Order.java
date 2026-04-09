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
}
