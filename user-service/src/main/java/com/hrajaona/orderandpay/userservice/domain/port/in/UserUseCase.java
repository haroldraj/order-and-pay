package com.hrajaona.orderandpay.userservice.domain.port.in;

import com.hrajaona.orderandpay.userservice.application.dto.UserResponse;

import java.util.List;

public interface UserUseCase {
    List<UserResponse> getAllUsers();
}
