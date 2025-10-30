package com.hrajaona.orderandpay.orderservice.adapters.out.persistence.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "order_status_history")
public class OrderStatusHistoryJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String previousStatus;

    @Column
    private String status;

    @Column
    private String changedBy;

    @Column
    private LocalDateTime changedAt;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private OrderJpa order;
}
