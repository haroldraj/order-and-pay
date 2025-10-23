package com.hrajaona.user_service.adapters.out.persistence.repository;

import com.hrajaona.user_service.adapters.out.persistence.jpa.RoleJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleJpa, Long> {
}
