package com.hrajaona.user_service.domain.port.out;

import com.hrajaona.user_service.domain.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserPort {
    List<User> loadAllUsers();
}
