package com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryAssignmentId implements Serializable {

    @Column(name = "delivery_id")
    private UUID deliveryId;

    @Column(name = "driver_id")
    private UUID driverId;
}
