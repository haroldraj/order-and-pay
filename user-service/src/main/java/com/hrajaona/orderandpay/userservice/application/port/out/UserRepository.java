package com.hrajaona.orderandpay.userservice.application.port.out;

import com.hrajaona.orderandpay.userservice.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    List<User> findAll();
    User findByEmail(String email);
    User save(User user);
    Optional<User> findById(UUID id);
}
