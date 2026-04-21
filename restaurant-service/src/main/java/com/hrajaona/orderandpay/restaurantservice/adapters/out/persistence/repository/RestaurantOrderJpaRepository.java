package com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.repository;

import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.entity.RestaurantOrderJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RestaurantOrderJpaRepository extends JpaRepository<RestaurantOrderJpaEntity, UUID> {
    @Query("""
        SELECT o FROM RestaurantOrderJpaEntity o
        JOIN FETCH o.restaurant
        WHERE o.orderId = :orderId AND o.restaurant.id = :restaurantId
""")
    Optional<RestaurantOrderJpaEntity> findByOrderIdAndRestaurantId(
            @Param("orderId") UUID orderId,
            @Param("restaurantId") UUID restaurantId);
}
