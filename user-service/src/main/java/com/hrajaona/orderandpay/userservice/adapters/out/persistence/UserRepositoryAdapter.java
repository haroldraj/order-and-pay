package com.hrajaona.orderandpay.userservice.adapters.out.persistence;

import com.hrajaona.orderandpay.userservice.adapters.out.persistence.mapper.UserPersistenceMapper;
import com.hrajaona.orderandpay.userservice.adapters.out.persistence.repository.AddressRepository;
import com.hrajaona.orderandpay.userservice.adapters.out.persistence.repository.UserRepository;
import com.hrajaona.orderandpay.userservice.application.port.out.UserPort;
import com.hrajaona.orderandpay.userservice.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserPort {
    private final UserRepository userRepository;
    private final UserPersistenceMapper userPersistenceMapper;
    private final AddressRepository addressRepository;

    @Override
    public List<User> loadAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userPersistenceMapper::toDomain)
                .toList();
    }

}
