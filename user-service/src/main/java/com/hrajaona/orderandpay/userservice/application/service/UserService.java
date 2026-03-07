package com.hrajaona.orderandpay.userservice.application.service;

import com.hrajaona.library.enums.RoleType;
import com.hrajaona.orderandpay.userservice.adapters.in.web.dto.UserRequest;
import com.hrajaona.orderandpay.userservice.adapters.in.web.mapper.UserWebMapper;
import com.hrajaona.orderandpay.userservice.application.port.in.UserUseCase;
import com.hrajaona.orderandpay.userservice.application.port.out.UserRepository;
import com.hrajaona.orderandpay.userservice.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements UserUseCase {

    private final UserRepository userRepository;
    private final UserWebMapper userWebMapper;

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User addUser(UserRequest userRequest) {
        User newUser = User.builder()
                .id(UUID.randomUUID())
                .userName(userRequest.getUserName())
                .role(RoleType.CUSTOMER)
                .status(userRequest.getStatus())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .phoneNumber(userRequest.getPhoneNumber())
                .emailAddress(userRequest.getEmailAddress())
                .build();
        return userRepository.save(newUser);
    }

    @Override
    public User getUserById(UUID id) {
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
    }
}
