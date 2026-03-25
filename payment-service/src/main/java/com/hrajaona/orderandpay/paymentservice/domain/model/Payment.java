package com.hrajaona.orderandpay.paymentservice.domain.model;

import com.hrajaona.library.enums.PaymentStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private UUID id;
    private UUID orderId;
    private UUID userId;
    private BigDecimal amount;
    private String method;
    private PaymentStatus status;
    private String reference;
    private LocalDateTime valueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
