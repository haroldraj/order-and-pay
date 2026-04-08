package com.hrajaona.orderandpay.paymentservice.adapters.out.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "refunds")
@Data
@EqualsAndHashCode
public class RefundJpaEntity {
    @Id
    private UUID id;

    @Column
    private BigDecimal amount;

    @Column
    private String reason;

    @Column
    private String status;

    @Column
    private LocalDateTime refundDate;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private PaymentJpaEntity payment;

}