package com.hrajaona.orderandpay.orderservice.adapters.out.persistence.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "order_items")
public class OrderItemJpaEntity {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column
    private UUID productId;

    @Column
    private String productName;

    @Column
    private int quantity;

    @Column
    private BigDecimal unitPrice;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private OrderJpaEntity order;
}
