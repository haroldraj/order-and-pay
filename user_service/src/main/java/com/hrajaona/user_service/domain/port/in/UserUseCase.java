package com.hrajaona.user_service.domain.port.in;

import com.hrajaona.user_service.application.dto.UserResponse;

import java.util.List;

public interface UserUseCase {
    List<UserResponse> getAllUsers();
}
