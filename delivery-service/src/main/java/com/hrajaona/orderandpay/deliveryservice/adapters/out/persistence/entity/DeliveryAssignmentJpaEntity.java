package com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "delivery_assignment")
@Getter
@Setter
@EqualsAndHashCode
public class DeliveryAssignmentJpaEntity {

    @EmbeddedId
    private DeliveryAssignmentId id;

    @Column
    private String status;

    @Column
    private LocalDateTime assignedAt;

    @Column
    private LocalDateTime acceptedAt;

    @Column
    private LocalDateTime completedAt;

    @Column
    private LocalDateTime cancelledAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("driverId")
    @JoinColumn(name = "driver_id")
    private DriverJpaEntity driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("deliveryId")
    @JoinColumn(name = "delivery_id")
    private DeliveryJpaEntity delivery;


}
