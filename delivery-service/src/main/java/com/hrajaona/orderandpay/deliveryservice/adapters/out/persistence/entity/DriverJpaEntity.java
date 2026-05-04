package com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "drivers")
@Getter
@Setter
@EqualsAndHashCode
public class DriverJpaEntity {
    @Id
    private UUID id;

    @Column
    private String name;

    @Column
    private String phoneNumber;

    @Column
    private String emailAddress;

    @Column
    private String vehicleType;

    @Column
    private boolean available;

    @Column
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "driver")
    private List<DeliveryAssignmentJpaEntity> assignments;
}
