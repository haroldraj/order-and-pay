package com.hrajaona.orderandpay.deliveryservice.adapters;

import com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.repository.DriverJpaRepository;
import com.hrajaona.orderandpay.deliveryservice.application.port.out.DriverRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DriverPersistenceAdapter implements DriverRepositoryPort {
    private final DriverJpaRepository driverJpaRepository;
}
