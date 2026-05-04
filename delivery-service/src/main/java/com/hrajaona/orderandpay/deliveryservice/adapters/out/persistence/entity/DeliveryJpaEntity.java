package com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.entity;

import com.hrajaona.library.model.AddressSnapshot;
import com.hrajaona.library.model.RestaurantSnapshot;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "deliveries")
@Getter
@Setter
@EqualsAndHashCode
public class DeliveryJpaEntity {

    @Id
    private UUID id;

    @Column
    private UUID orderId;

    @Column
    private UUID userId;

    @Column
    private UUID restaurantId;

    @Column(columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private AddressSnapshot addressSnapshot;

    @Column(columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private RestaurantSnapshot restaurantSnapshot;

    @Column
    private String status;

    @Column
    private LocalDateTime estimatedDeliveryTime;

    @Column
    private LocalDateTime deliveredAt;

    @Column
    private LocalDateTime pickedUpAt;

    @Column
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "delivery")
    private List<DeliveryAssignmentJpaEntity> assignments;
}
