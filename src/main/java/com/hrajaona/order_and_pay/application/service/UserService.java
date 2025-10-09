package com.hrajaona.order_and_pay.application.service;

import com.hrajaona.order_and_pay.adapters.in.web.model.response.UserResponse;
import com.hrajaona.order_and_pay.application.mapper.UserMapper;
import com.hrajaona.order_and_pay.domain.port.out.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper ;

    public List<UserResponse> getAllUsersList() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponse)
                .toList();
    }
}
