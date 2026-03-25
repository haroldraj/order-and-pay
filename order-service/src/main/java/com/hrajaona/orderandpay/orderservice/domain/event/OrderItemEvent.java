package com.hrajaona.orderandpay.orderservice.domain.event;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemEvent {
    private UUID id;
    private UUID productId;
    private String productName;
    private int quantity;
    private BigDecimal unitPrice;
}
