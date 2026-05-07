package com.hrajaona.orderandpay.deliveryservice.domain.model;

import com.hrajaona.library.enums.VehicleType;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Driver {
    private UUID id;
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private VehicleType vehicleType;
    private boolean available;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public void markAsUnavailable() {
        this.available = false;
    }

    public void markAsAvailable() {
        this.available = true;
    }
}
