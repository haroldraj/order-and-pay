package com.hrajaona.orderandpay.deliveryservice.application.handler;

import com.hrajaona.library.events.OrderReadyForDeliveryEvent;
import com.hrajaona.orderandpay.deliveryservice.application.mapper.DeliveryApplicationMapper;
import com.hrajaona.orderandpay.deliveryservice.application.port.in.HandleOrderReadyUseCase;
import com.hrajaona.orderandpay.deliveryservice.application.port.out.DeliveryRepositoryPort;
import com.hrajaona.orderandpay.deliveryservice.application.port.out.DriverRepositoryPort;
import com.hrajaona.orderandpay.deliveryservice.domain.model.Delivery;
import com.hrajaona.orderandpay.deliveryservice.domain.model.Driver;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Component
@Slf4j
@RequiredArgsConstructor
public class OrderReadyForDeliveryHandler implements HandleOrderReadyUseCase {
    private final DriverRepositoryPort driverRepositoryPort;
    private final DeliveryRepositoryPort deliveryRepositoryPort;
    private final DeliveryApplicationMapper deliveryApplicationMapper;

    @Override
    @Transactional
    public void handle(OrderReadyForDeliveryEvent order, String correlationId) {
        Delivery delivery = deliveryApplicationMapper.toDomain(order);

        // TODO Save Delivery
        deliveryRepositoryPort.save(delivery);

        // Find available driver
        Driver driver = driverRepositoryPort.findAvailableDriver();

        // TODO Save delivery_assignment


    }

}
