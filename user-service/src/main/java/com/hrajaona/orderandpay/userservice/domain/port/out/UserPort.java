package com.hrajaona.orderandpay.userservice.domain.port.out;

import com.hrajaona.orderandpay.userservice.domain.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserPort {
    List<User> loadAllUsers();
}
