package com.hrajaona.orderandpay.deliveryservice.application.handler;

import com.hrajaona.library.events.OrderReadyForDeliveryEvent;
import com.hrajaona.orderandpay.deliveryservice.application.port.in.HandleOrderReadyUseCase;
import com.hrajaona.orderandpay.deliveryservice.application.port.out.DriverRepositoryPort;
import com.hrajaona.orderandpay.deliveryservice.domain.model.Driver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrderReadyForDeliveryHandler implements HandleOrderReadyUseCase {
    private final DriverRepositoryPort driverRepositoryPort;

    @Override
    public void handle(OrderReadyForDeliveryEvent order, String correlationId) {
        Driver driver = driverRepositoryPort.findAvailableDriver();
        assignDriverToOrder(order.getOrderId(), driver.getId());
    }

    private void assignDriverToOrder(UUID orderId, UUID driverId) {}
}
