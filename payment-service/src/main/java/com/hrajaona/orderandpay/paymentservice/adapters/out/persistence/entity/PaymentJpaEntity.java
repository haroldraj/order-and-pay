package com.hrajaona.orderandpay.paymentservice.adapters.out.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Table(name = "payments")
@Entity
@Data
@EqualsAndHashCode
public class PaymentJpaEntity {
    @Id
    private UUID id;

    @Column(nullable = false)
    private UUID orderId;

    @Column(nullable = false)
    private UUID userId;

    @Column
    private BigDecimal amount;

    @Column
    private String method;

    @Column
    private String status;

    @Column
    private String reference;

    @Column
    private LocalDateTime valueDate;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "payment")
    private List<RefundJpaEntity> refunds;
}