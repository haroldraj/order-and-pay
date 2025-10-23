package com.hrajaona.user_service.adapters.out.persistence.repository;

import com.hrajaona.user_service.adapters.out.persistence.jpa.UserJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserJpa, Long> {
}
