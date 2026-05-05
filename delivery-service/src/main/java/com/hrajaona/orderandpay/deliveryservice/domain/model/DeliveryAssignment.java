package com.hrajaona.orderandpay.deliveryservice.domain.model;

import com.hrajaona.library.enums.DeliveryStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryAssignment {
    private UUID deliveryId;
    private UUID driverId;
    private DeliveryStatus status;
    private LocalDateTime acceptedAt;
    private LocalDateTime assignedAt;
    private LocalDateTime completedAt;
    private LocalDateTime cancelledAt;
}
