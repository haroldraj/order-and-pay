package com.hrajaona.orderandpay.userservice.adapters.out.persistence.adapter;

import com.hrajaona.orderandpay.userservice.adapters.mapper.UserMapper;
import com.hrajaona.orderandpay.userservice.adapters.out.persistence.repository.UserRepository;
import com.hrajaona.orderandpay.userservice.domain.model.User;
import com.hrajaona.orderandpay.userservice.domain.port.out.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserAdapter implements UserPort {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<User> loadAllUsers() {
        return userMapper.jpaToDomainList(userRepository.findAll());
    }
}
