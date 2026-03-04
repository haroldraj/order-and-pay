package com.hrajaona.orderandpay.paymentservice.infrastructure.persistence.entity;

import com.hrajaona.orderandpay.paymentservice.infrastructure.persistence.entity.RefundEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "payments")
@Entity
@Data
@EqualsAndHashCode
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private UUID paymentIdf;

    @Column
    private UUID orderIdf;

    @Column
    private UUID userIdf;

    @Column
    private double amount;

    @Column
    private String method;

    @Column
    private String status;

    @Column
    private String description;

    @Column
    private String reference;

    @Column
    private LocalDateTime valueDate;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @OneToOne(mappedBy = "payment")
    private RefundEntity refund;
}