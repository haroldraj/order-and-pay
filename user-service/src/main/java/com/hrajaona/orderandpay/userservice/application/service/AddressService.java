package com.hrajaona.orderandpay.userservice.application.service;

import com.hrajaona.orderandpay.userservice.application.port.in.AddressUseCase;
import com.hrajaona.orderandpay.userservice.application.port.out.AddressRepositoryPort;
import com.hrajaona.orderandpay.userservice.domain.model.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressService implements AddressUseCase {
    private final AddressRepositoryPort addressRepositoryPort;

    @Override
    public Address getAddressById(UUID id) {
        return addressRepositoryPort.findById(id).orElseThrow(() -> new RuntimeException("Address with id " + id + " not found"));
    }
}
