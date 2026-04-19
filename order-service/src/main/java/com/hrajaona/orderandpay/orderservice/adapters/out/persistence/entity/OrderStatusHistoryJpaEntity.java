package com.hrajaona.orderandpay.orderservice.adapters.out.persistence.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "order_status_history")
public class OrderStatusHistoryJpaEntity {
    @Id
    private UUID id;

    @Column
    private UUID orderId;

    @Column
    private String previousStatus;

    @Column
    private String status;

    @Column
    private LocalDateTime changedAt;
//
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "order_id", referencedColumnName = "id")
//    private OrderJpaEntity order;
}
