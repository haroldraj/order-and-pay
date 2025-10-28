package com.hrajaona.orderandpay.userservice.adapters.out.persistence.repository;

import com.hrajaona.orderandpay.userservice.adapters.out.persistence.entity.UserJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserJpa, Long> {
    Optional<UserJpa> findByEmailAddress(String email);

//    @Query("UPDATE UserJpa u SET ")
}
