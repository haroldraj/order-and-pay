package com.hrajaona.orderandpay.paymentservice.domain.model;

import com.hrajaona.library.enums.RefundStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Refund {
    private UUID id;
    private double amount;
    private String reason;
    private RefundStatus status;
    private LocalDateTime refundDate;
    private Payment payment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
