package com.hrajaona.orderandpay.userservice.adapters.out.persistence.repository;


import com.hrajaona.orderandpay.userservice.adapters.out.persistence.entity.AddressJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AddressJpaRepository extends JpaRepository<AddressJpaEntity, UUID> {

    @Query("SELECT a FROM AddressJpaEntity a WHERE a.user.id = :uid")
    List<AddressJpaEntity> findAllByUserId(@Param("id") UUID id);
}
