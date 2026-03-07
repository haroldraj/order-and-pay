package com.hrajaona.orderandpay.userservice.adapters.out.persistence.repository;

import com.hrajaona.orderandpay.userservice.adapters.out.persistence.entity.UserJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<UserJpaEntity, UUID> {
    Optional<UserJpaEntity> findByEmailAddress(String email);

//    @Query("UPDATE UserJpa u SET ")
}
