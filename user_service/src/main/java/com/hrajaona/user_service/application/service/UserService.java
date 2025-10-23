package com.hrajaona.user_service.application.service;

import com.hrajaona.user_service.adapters.mapper.UserMapper;
import com.hrajaona.user_service.application.dto.UserResponse;
import com.hrajaona.user_service.domain.port.in.UserUseCase;
import com.hrajaona.user_service.domain.port.out.UserPort;
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
