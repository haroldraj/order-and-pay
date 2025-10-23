package com.hrajaona.user_service.adapters.out.persistence.adapter;

import com.hrajaona.user_service.adapters.mapper.UserMapper;
import com.hrajaona.user_service.adapters.out.persistence.repository.UserRepository;
import com.hrajaona.user_service.domain.model.User;
import com.hrajaona.user_service.domain.port.out.UserPort;
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
