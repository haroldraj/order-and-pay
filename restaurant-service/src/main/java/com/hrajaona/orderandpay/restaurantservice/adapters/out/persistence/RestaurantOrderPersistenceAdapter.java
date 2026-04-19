package com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence;

import com.hrajaona.library.enums.OrderStatus;
import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.entity.RestaurantJpaEntity;
import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.entity.RestaurantOrderJpaEntity;
import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.mapper.RestaurantOrderPersistenceMapper;
import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.repository.RestaurantOrderJpaRepository;
import com.hrajaona.orderandpay.restaurantservice.application.port.out.RestaurantOrderRepositoryPort;
import com.hrajaona.orderandpay.restaurantservice.domain.model.RestaurantOrder;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RestaurantOrderPersistenceAdapter implements RestaurantOrderRepositoryPort {
    private final RestaurantOrderJpaRepository repository;
    private final RestaurantOrderPersistenceMapper mapper;
    private final EntityManager entityManager;

    @Override
    public void save(RestaurantOrder restaurantOrder) {
        restaurantOrder.setId(UUID.randomUUID());
        restaurantOrder.setStatus(OrderStatus.PREPARING);

        try {
            RestaurantJpaEntity restaurant = entityManager.getReference(RestaurantJpaEntity.class, restaurantOrder.getRestaurantId());
            RestaurantOrderJpaEntity newRestaurantOrder = mapper.toEntity(restaurantOrder);
            newRestaurantOrder.setRestaurant(restaurant);

            repository.save(newRestaurantOrder);
        } catch (Exception e) {
            throw new RuntimeException("Cannot save RestaurantOrder :" + e);
        }
    }
}
