package com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence;

import com.hrajaona.library.enums.OrderStatus;
import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.entity.RestaurantJpaEntity;
import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.entity.RestaurantOrderJpaEntity;
import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.mapper.RestaurantOrderPersistenceMapper;
import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.mapper.RestaurantPersistenceMapper;
import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.repository.RestaurantOrderJpaRepository;
import com.hrajaona.orderandpay.restaurantservice.application.port.out.RestaurantOrderRepositoryPort;
import com.hrajaona.orderandpay.restaurantservice.application.port.out.RestaurantRepositoryPort;
import com.hrajaona.orderandpay.restaurantservice.domain.model.Restaurant;
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
    private final RestaurantRepositoryPort restaurantRepositoryPort;
    private final RestaurantPersistenceMapper restaurantPersistenceMapper;

    @Override
    public void save(RestaurantOrder restaurantOrder) {
        restaurantOrder.setId(UUID.randomUUID());
        restaurantOrder.setStatus(OrderStatus.PREPARING);

        try {
            Restaurant restaurant = restaurantRepositoryPort.findById(restaurantOrder.getRestaurantId());
            RestaurantOrderJpaEntity newRestaurantOrder = mapper.toEntity(restaurantOrder);
            newRestaurantOrder.setRestaurant(restaurantPersistenceMapper.toEntity(restaurant));

            repository.save(newRestaurantOrder);
        } catch (Exception e) {
            throw new RuntimeException("Cannot save RestaurantOrder :" + e);
        }
    }
}
