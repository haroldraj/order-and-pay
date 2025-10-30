package com.hrajaona.orderandpay.orderservice.adapters.out.persistence.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "order_items")
public class OrderItemJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private UUID orderItemIdf;

    @Column
    private UUID itemIdf;

    @Column
    private int quantity;

    @Column
    private double unitPrice;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private OrderJpa order;
}
