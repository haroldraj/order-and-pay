package com.hrajaona.orderandpay.userservice.application.port.in;

import com.hrajaona.orderandpay.userservice.domain.model.Address;

import java.util.UUID;

public interface AddressUseCase {
    Address getAddressById(UUID id);
}
