package com.hrajaona.order_and_pay.domain.service;

import com.hrajaona.order_and_pay.adapters.in.response.UserResponse;
import com.hrajaona.order_and_pay.adapters.out.mapper.UserMapper;
import com.hrajaona.order_and_pay.domain.port.out.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponse)
                .toList();
    }
}
