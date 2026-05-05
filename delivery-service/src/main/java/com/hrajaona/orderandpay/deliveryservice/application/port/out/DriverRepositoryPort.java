package com.hrajaona.orderandpay.deliveryservice.application.port.out;

import com.hrajaona.orderandpay.deliveryservice.domain.model.Driver;

import java.util.List;

public interface DriverRepositoryPort {
    List<Driver> findAll();
}
