package com.hrajaona.orderandpay.orderservice.adapters.out.persistence.entity;

import com.hrajaona.orderandpay.orderservice.adapters.out.persistence.converter.JsonMapConverter;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "orders")
public class OrderJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private UUID orderIdf;

    @Column
    private UUID userIdf;

    @Column
    private UUID addressIdf;

    @Column
    private UUID restaurantIdf;

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
    private LocalDateTime orderDate;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "order")
    private List<OrderItemJpa> orderItems;

    @OneToMany(mappedBy = "order")
    private List<OrderStatusHistoryJpa> orderStatusHistories;

}
