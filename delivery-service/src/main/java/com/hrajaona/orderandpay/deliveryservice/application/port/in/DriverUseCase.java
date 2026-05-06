package com.hrajaona.orderandpay.deliveryservice.application.port.in;

import com.hrajaona.orderandpay.deliveryservice.domain.model.Driver;

import java.util.List;

public interface DriverUseCase {
    List<Driver> getAll();
    Driver getAvailableDriver();
}
