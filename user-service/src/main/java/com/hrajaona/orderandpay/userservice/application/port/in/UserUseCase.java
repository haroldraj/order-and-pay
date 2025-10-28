package com.hrajaona.orderandpay.userservice.application.port.in;

import com.hrajaona.orderandpay.userservice.adapters.in.web.dto.UserResponse;
import com.hrajaona.orderandpay.userservice.domain.model.User;

import java.util.List;

public interface UserUseCase {
    List<UserResponse> getAllUsers();
}
