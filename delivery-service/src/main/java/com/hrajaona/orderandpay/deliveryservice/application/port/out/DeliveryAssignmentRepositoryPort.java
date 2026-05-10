package com.hrajaona.orderandpay.deliveryservice.application.port.out;


import java.util.UUID;

public interface DeliveryAssignmentRepositoryPort {
    void assignDriverToDelivery(UUID driverId, UUID deliveryId);
}
