package com.hrajaona.orderandpay.orderservice.adapters.out.persistence.entity;

import com.hrajaona.orderandpay.orderservice.domain.model.AddressSnapshot;
import com.hrajaona.orderandpay.orderservice.domain.model.RestaurantSnapshot;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "orders")
public class OrderJpaEntity {
    @Id
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

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private AddressSnapshot addressSnapshot;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private RestaurantSnapshot restaurantSnapshot;

    @Column
    private LocalDateTime valueDate;

    @Column
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "order")
    private List<OrderItemJpaEntity> orderItems;

    @OneToMany(mappedBy = "order")
    private List<OrderStatusHistoryJpaEntity> orderStatusHistories;

}
