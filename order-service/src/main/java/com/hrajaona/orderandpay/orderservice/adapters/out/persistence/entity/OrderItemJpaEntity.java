package com.hrajaona.orderandpay.orderservice.adapters.out.persistence.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "order_items")
public class OrderItemJpaEntity {
    @Id
    private UUID id;

    @Column
    private UUID itemId;

    @Column
    private int quantity;

    @Column
    private double unitPrice;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private OrderJpaEntity order;
}
