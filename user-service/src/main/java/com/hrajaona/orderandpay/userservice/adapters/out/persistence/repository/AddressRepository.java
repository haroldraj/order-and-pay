package com.hrajaona.orderandpay.userservice.adapters.out.persistence.repository;


import com.hrajaona.orderandpay.userservice.adapters.out.persistence.entity.AddressJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<AddressJpa, Long> {

    @Query("SELECT a FROM AddressJpa a WHERE a.user.userIdf = :userIdf")
    List<AddressJpa> findAllByUserIdf(@Param("userIdf") UUID userIdf);
}
