package com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.entity;

import com.hrajaona.library.enums.OrderStatus;
import com.hrajaona.library.model.CustomerSnapshot;
import com.hrajaona.library.model.OrderItemPayload;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "restaurant_orders")
public class RestaurantOrderJpaEntity {
    @Id
    private UUID id;

    @Column
    private UUID orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id", insertable = false, updatable = false)
    private RestaurantJpaEntity restaurant;

    @Column
    private String status;

    @Column
    private BigDecimal amount;

    @Column
    @JdbcTypeCode(SqlTypes.JSON)
    private List<OrderItemPayload> itemsSnapshot;

    @Column
    @JdbcTypeCode(SqlTypes.JSON)
    private CustomerSnapshot customerSnapshot;

    @Column
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}