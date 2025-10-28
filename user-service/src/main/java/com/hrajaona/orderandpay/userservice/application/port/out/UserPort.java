package com.hrajaona.orderandpay.userservice.application.port.out;

import com.hrajaona.orderandpay.userservice.adapters.in.web.dto.UserRequest;
import com.hrajaona.orderandpay.userservice.domain.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserPort {
    List<User> loadAllUsers();
    User loadUserByEmail(String email);
    User saveUser(User user);
}
