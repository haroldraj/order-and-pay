package com.hrajaona.orderandpay.userservice.application.port.in;

import com.hrajaona.orderandpay.userservice.adapters.in.web.dto.UserRequest;
import com.hrajaona.orderandpay.userservice.domain.model.User;

import java.util.List;
import java.util.UUID;

public interface UserUseCase {
    List<User> getAllUsers();
    User getUserByEmail(String email);
    User addUser(UserRequest userRequest);
    User getUserById(UUID id);
}
