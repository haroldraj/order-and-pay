package com.hrajaona.orderandpay.userservice.application.service;

import com.hrajaona.orderandpay.userservice.adapters.mapper.UserMapper;
import com.hrajaona.orderandpay.userservice.application.dto.UserResponse;
import com.hrajaona.orderandpay.userservice.domain.port.in.UserUseCase;
import com.hrajaona.orderandpay.userservice.domain.port.out.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserUseCase {

    private final UserPort userPort;
    private final UserMapper userMapper;

    @Override
    public List<UserResponse> getAllUsers(){
        return userMapper.domainToResponseList(userPort.loadAllUsers());
    }
}
