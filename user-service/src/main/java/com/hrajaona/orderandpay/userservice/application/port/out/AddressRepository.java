package com.hrajaona.orderandpay.userservice.application.port.out;

import com.hrajaona.orderandpay.userservice.domain.model.Address;

import java.util.Optional;
import java.util.UUID;

public interface AddressRepository {
    Optional<Address> findById(UUID id);
}
