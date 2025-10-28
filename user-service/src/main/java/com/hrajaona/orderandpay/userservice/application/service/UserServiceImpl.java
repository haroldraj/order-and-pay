package com.hrajaona.orderandpay.userservice.application.service;

import com.hrajaona.orderandpay.userservice.adapters.in.web.mapper.UserWebMapper;
import com.hrajaona.orderandpay.userservice.adapters.in.web.dto.UserResponse;
import com.hrajaona.orderandpay.userservice.application.port.in.UserUseCase;
import com.hrajaona.orderandpay.userservice.application.port.out.UserPort;
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
}
