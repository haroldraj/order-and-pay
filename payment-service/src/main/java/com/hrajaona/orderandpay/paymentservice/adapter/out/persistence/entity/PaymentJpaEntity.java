package com.hrajaona.orderandpay.paymentservice.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Table(name = "payments")
@Entity
@Data
@EqualsAndHashCode
public class PaymentJpaEntity {
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