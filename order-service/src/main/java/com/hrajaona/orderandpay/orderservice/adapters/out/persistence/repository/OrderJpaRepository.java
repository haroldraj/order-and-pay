package com.hrajaona.orderandpay.orderservice.adapters.out.persistence.repository;

import com.hrajaona.orderandpay.orderservice.adapters.out.persistence.entity.OrderJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderJpaEntity, UUID> {

    Optional<OrderJpaEntity> findByIdAndUserIdAndAmount( UUID id, UUID userId, BigDecimal amount);
//    @Query("SELECT o FROM OrderJpaEntity o WHERE o.id = :id AND o.userId = :userId AND o.amount = :amount")
//    Optional<OrderJpaEntity> findByIdAndUserIdAndAmount(
//            @Param("id") UUID id,
//            @Param("userId") UUID userId,
//            @Param("amount") BigDecimal amount);

    @Query("""
        SELECT o FROM OrderJpaEntity o
        LEFT JOIN FETCH o.orderItems
        WHERE o.id =:id AND o.userId = :userId
    """)
    Optional<OrderJpaEntity> findByIdAndUserId(
            @Param("id") UUID id,
            @Param("userId") UUID userId);

//    Optional<OrderJpaEntity> updateOrInsert(OrderJpaEntity orderJpaEntity);

}
