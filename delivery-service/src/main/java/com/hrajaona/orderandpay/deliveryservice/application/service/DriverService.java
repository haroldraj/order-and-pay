package com.hrajaona.orderandpay.deliveryservice.application.service;

import com.hrajaona.orderandpay.deliveryservice.application.port.in.DriverUseCase;
import com.hrajaona.orderandpay.deliveryservice.application.port.out.DriverRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DriverService implements DriverUseCase {
    private final DriverRepositoryPort driverRepositoryPort;
}
