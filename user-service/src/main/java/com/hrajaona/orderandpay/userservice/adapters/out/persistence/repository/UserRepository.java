package com.hrajaona.orderandpay.userservice.adapters.out.persistence.repository;

import com.hrajaona.orderandpay.userservice.adapters.out.persistence.entity.UserJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserJpa, Long> {
}
