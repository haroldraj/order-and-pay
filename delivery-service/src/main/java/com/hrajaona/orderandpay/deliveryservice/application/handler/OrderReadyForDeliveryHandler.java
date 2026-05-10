package com.hrajaona.orderandpay.deliveryservice.application.handler;

import com.hrajaona.library.enums.DeliveryStatus;
import com.hrajaona.library.events.OrderReadyForDeliveryEvent;
import com.hrajaona.orderandpay.deliveryservice.application.mapper.DeliveryApplicationMapper;
import com.hrajaona.orderandpay.deliveryservice.application.port.in.HandleOrderReadyUseCase;
import com.hrajaona.orderandpay.deliveryservice.application.port.out.DeliveryAssignmentRepositoryPort;
import com.hrajaona.orderandpay.deliveryservice.application.port.out.DeliveryRepositoryPort;
import com.hrajaona.orderandpay.deliveryservice.application.port.out.DriverRepositoryPort;
import com.hrajaona.orderandpay.deliveryservice.domain.model.Delivery;
import com.hrajaona.orderandpay.deliveryservice.domain.model.Driver;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
@Slf4j
@RequiredArgsConstructor
public class OrderReadyForDeliveryHandler implements HandleOrderReadyUseCase {
    private final DriverRepositoryPort driverRepositoryPort;
    private final DeliveryRepositoryPort deliveryRepositoryPort;
    private final DeliveryApplicationMapper deliveryApplicationMapper;
    private final DeliveryAssignmentRepositoryPort deliveryAssignmentRepositoryPort;

    @Override
    @Transactional
    public void handle(OrderReadyForDeliveryEvent order, String correlationId) {
        Delivery savedDelivery = saveDelivery(deliveryApplicationMapper.toDomain(order));

        Driver driver = driverRepositoryPort.findAvailableDriver();

        // TODO Save delivery_assignment
        assignDriverToDelivery(driver, savedDelivery);


    }

    private Delivery saveDelivery(Delivery delivery) {
        delivery.setEstimatedDeliveryTime(LocalDateTime.now().plusMinutes(15));
        delivery.setStatus(DeliveryStatus.PENDING_ASSIGNMENT);
        return deliveryRepositoryPort.save(delivery);

    }

    private void assignDriverToDelivery(Driver driver, Delivery delivery) {
        deliveryAssignmentRepositoryPort.assignDriverToDelivery(driver.getId(), delivery.getId());
    }

}
