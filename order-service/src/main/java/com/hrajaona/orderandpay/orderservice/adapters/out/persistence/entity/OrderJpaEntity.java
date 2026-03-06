package com.hrajaona.orderandpay.orderservice.adapters.out.persistence.entity;

import com.hrajaona.orderandpay.orderservice.adapters.out.persistence.converter.JsonMapConverter;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "orders")
public class OrderJpaEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private UUID userId;

    @Column
    private UUID addressId;

    @Column
    private UUID restaurantId;

    @Column
    private String status;

    @Column
    private double totalAmount;

    @Column
    private String paymentStatus;

    @Column
    private String deliveryStatus;

    @Column(columnDefinition = "jsonb")
    @Convert(converter = JsonMapConverter.class)
    private Map<String, Object> addressSnapshot;

    @Column(columnDefinition = "jsonb")
    @Convert(converter = JsonMapConverter.class)
    private Map<String, Object> restaurantSnapshot;

    @Column
    private LocalDateTime valueDate;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "order")
    private List<OrderItemJpaEntity> orderItems;

    @OneToMany(mappedBy = "order")
    private List<OrderStatusHistoryJpaEntity> orderStatusHistories;

}
