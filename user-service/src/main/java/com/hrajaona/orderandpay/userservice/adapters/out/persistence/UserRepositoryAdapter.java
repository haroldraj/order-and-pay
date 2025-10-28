package com.hrajaona.orderandpay.userservice.adapters.out.persistence;

import com.hrajaona.orderandpay.userservice.adapters.in.web.dto.UserRequest;
import com.hrajaona.orderandpay.userservice.adapters.out.persistence.entity.UserJpa;
import com.hrajaona.orderandpay.userservice.adapters.out.persistence.mapper.UserPersistenceMapper;
import com.hrajaona.orderandpay.userservice.adapters.out.persistence.repository.AddressRepository;
import com.hrajaona.orderandpay.userservice.adapters.out.persistence.repository.UserRepository;
import com.hrajaona.orderandpay.userservice.application.port.out.UserPort;
import com.hrajaona.orderandpay.userservice.domain.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserRepositoryAdapter implements UserPort {
    private final UserRepository userRepository;
    private final UserPersistenceMapper userPersistenceMapper;
    private final AddressRepository addressRepository;

    @Override
    public List<User> loadAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userPersistenceMapper::toDomain)
                .toList();
    }

    @Override
    public User loadUserByEmail(String email) {
        return userPersistenceMapper.toDomain(userRepository.findByEmailAddress(email).orElseThrow());
    }

    @Override
    public User saveUser(User user) {
        UUID userIdf = UUID.randomUUID();
        user.setUserIdf(userIdf);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        try {
            log.info("Saving user with userIdf: {}", userIdf);
            UserJpa savedUser = userRepository.save(userPersistenceMapper.toJpa(user));
            return userPersistenceMapper.toDomain(savedUser);

        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

}
