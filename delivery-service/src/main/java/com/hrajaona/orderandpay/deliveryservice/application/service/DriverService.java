package com.hrajaona.orderandpay.deliveryservice.application.service;

import com.hrajaona.orderandpay.deliveryservice.application.port.in.DriverUseCase;
import com.hrajaona.orderandpay.deliveryservice.application.port.out.DriverRepositoryPort;
import com.hrajaona.orderandpay.deliveryservice.domain.model.Driver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverService implements DriverUseCase {
    private final DriverRepositoryPort driverRepositoryPort;

    @Override
    public List<Driver> getAll() {
        return driverRepositoryPort.findAll();
    }
}
