package com.hrajaona.orderandpay.userservice.adapters.out.persistence;

import com.hrajaona.orderandpay.userservice.adapters.out.persistence.mapper.AddressPersistenceMapper;
import com.hrajaona.orderandpay.userservice.adapters.out.persistence.repository.AddressJpaRepository;
import com.hrajaona.orderandpay.userservice.application.port.out.AddressRepository;
import com.hrajaona.orderandpay.userservice.domain.model.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AddressPersistenceAdapter implements AddressRepository {
    private final AddressJpaRepository addressJpaRepository;
    private final AddressPersistenceMapper addressPersistenceMapper;


    @Override
    public Optional<Address> findById(UUID id) {
        return addressJpaRepository.findById(id)
                .map(addressPersistenceMapper::toDomain);
    }
}
