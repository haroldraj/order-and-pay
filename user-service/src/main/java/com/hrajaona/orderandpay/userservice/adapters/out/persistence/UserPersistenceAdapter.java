package com.hrajaona.orderandpay.userservice.adapters.out.persistence;

import com.hrajaona.orderandpay.userservice.adapters.out.persistence.entity.UserJpaEntity;
import com.hrajaona.orderandpay.userservice.adapters.out.persistence.mapper.UserPersistenceMapper;
import com.hrajaona.orderandpay.userservice.adapters.out.persistence.repository.UserJpaRepository;
import com.hrajaona.orderandpay.userservice.application.port.out.UserRepositoryPort;
import com.hrajaona.orderandpay.userservice.domain.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserPersistenceAdapter implements UserRepositoryPort {
    private final UserPersistenceMapper userPersistenceMapper;
    private final UserJpaRepository userJpaRepository;

    @Override
    public List<User> findAll() {
        return userJpaRepository.findAll()
                .stream()
                .map(userPersistenceMapper::toDomain)
                .toList();
    }

    @Override
    public User findByEmail(String email) {
        return userPersistenceMapper.toDomain(userJpaRepository.findByEmailAddress(email).orElseThrow());
    }

    @Override
    public User save(User user) {
        try {
            UserJpaEntity savedUser = userJpaRepository.save(userPersistenceMapper.toJpa(user));
            return userPersistenceMapper.toDomain(savedUser);

        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Optional<User> findById(UUID id) {
        return userJpaRepository.findById(id)
                .map(userPersistenceMapper::toDomain);
    }

}
