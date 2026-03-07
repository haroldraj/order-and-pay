package com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.repository;

import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.entity.RestaurantJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RestaurantJpaRepository extends JpaRepository<RestaurantJpaEntity, UUID> {
}
