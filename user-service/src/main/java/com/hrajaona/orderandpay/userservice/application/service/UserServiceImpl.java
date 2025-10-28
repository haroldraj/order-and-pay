package com.hrajaona.orderandpay.userservice.application.service;

import com.hrajaona.orderandpay.userservice.adapters.in.web.dto.UserRequest;
import com.hrajaona.orderandpay.userservice.adapters.in.web.mapper.UserWebMapper;
import com.hrajaona.orderandpay.userservice.adapters.in.web.dto.UserResponse;
import com.hrajaona.orderandpay.userservice.application.port.in.UserUseCase;
import com.hrajaona.orderandpay.userservice.application.port.out.UserPort;
import com.hrajaona.orderandpay.userservice.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserUseCase {

    private final UserPort userPort;
    private final UserWebMapper userWebMapper;

    @Override
    public List<UserResponse> getAllUsers(){
        return userPort.loadAllUsers()
                .stream()
                .map(userWebMapper::toResponse)
                .toList();
    }

    @Override
    public UserResponse getUserByEmail(String email) {
        return userWebMapper.toResponse(userPort.loadUserByEmail(email));
    }

    @Override
    public UserResponse addUser(UserRequest userRequest) {
        User newUser = userWebMapper.toDomain(userRequest);
        return userWebMapper.toResponse(userPort.saveUser(newUser));
    }
}
