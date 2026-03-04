package com.hrajaona.orderandpay.paymentservice.adapter.out.persistence.entity;

import com.hrajaona.orderandpay.paymentservice.adapter.out.persistence.entity.PaymentJpaEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "refunds")
@Data
@EqualsAndHashCode
public class RefundJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private UUID refundIdf;

    @Column
    private double amount;

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