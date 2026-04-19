package com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.repository;

import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.entity.RestaurantOrderStatusHistoryJpaEntity;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Registered
public interface RestaurantOrderStatusHistoryJpaRepository extends JpaRepository<RestaurantOrderStatusHistoryJpaEntity,UUID> {
}
