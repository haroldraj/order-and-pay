package com.hrajaona.orderandpay.deliveryservice.adapters;

import com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.mapper.DriverPersistenceMapper;
import com.hrajaona.orderandpay.deliveryservice.adapters.out.persistence.repository.DriverJpaRepository;
import com.hrajaona.orderandpay.deliveryservice.application.port.out.DriverRepositoryPort;
import com.hrajaona.orderandpay.deliveryservice.domain.model.Driver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DriverPersistenceAdapter implements DriverRepositoryPort {
    private final DriverJpaRepository driverJpaRepository;
    private final DriverPersistenceMapper driverPersistenceMapper;

    @Override
    public List<Driver> findAll() {
        return driverJpaRepository.findAll()
                .stream()
                .map(driverPersistenceMapper::toDomain)
                .toList();
    }

    @Override
    public Driver findAvailableDriver() {
        return driverJpaRepository.findAllAvailable()
                .stream()
                .findFirst()
                .map(driverPersistenceMapper::toDomain)
                .orElseThrow(() -> new RuntimeException("Not available Driver"));
    }
}
