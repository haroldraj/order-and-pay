package com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.repository;

import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.entity.MenuItemJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemJpaRepository extends JpaRepository<MenuItemJpaEntity, Long> {
}
