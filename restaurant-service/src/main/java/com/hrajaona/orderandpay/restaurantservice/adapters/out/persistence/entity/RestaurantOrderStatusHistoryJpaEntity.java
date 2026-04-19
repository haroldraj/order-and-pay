package com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "restaurant_order_status_history")
public class RestaurantOrderStatusHistoryJpaEntity {
    @Id
    private UUID id;

    @Column
    private UUID orderId;

    @Column
    private String previousStatus;

    @Column
    private String newStatus;

    @Column
    private LocalDateTime changedAt;
}