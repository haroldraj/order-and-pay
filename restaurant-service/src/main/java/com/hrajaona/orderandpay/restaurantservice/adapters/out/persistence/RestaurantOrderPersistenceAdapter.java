package com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence;

import com.hrajaona.library.enums.OrderStatus;
import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.entity.RestaurantJpaEntity;
import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.entity.RestaurantOrderJpaEntity;
import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.mapper.RestaurantOrderPersistenceMapper;
import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.repository.RestaurantJpaRepository;
import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.repository.RestaurantOrderJpaRepository;
import com.hrajaona.orderandpay.restaurantservice.application.port.out.RestaurantOrderRepositoryPort;
import com.hrajaona.orderandpay.restaurantservice.domain.model.RestaurantOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RestaurantOrderPersistenceAdapter implements RestaurantOrderRepositoryPort {
    private final RestaurantOrderJpaRepository repository;
    private final RestaurantOrderPersistenceMapper mapper;
    private final RestaurantJpaRepository restaurantJpaRepository;

    @Override
    public void save(RestaurantOrder restaurantOrder) {
        restaurantOrder.setId(UUID.randomUUID());

        try {
            RestaurantJpaEntity restaurant = restaurantJpaRepository.getReferenceById(restaurantOrder.getRestaurantId());
            RestaurantOrderJpaEntity newRestaurantOrder = mapper.toEntity(restaurantOrder);
            newRestaurantOrder.setRestaurant(restaurant);
            newRestaurantOrder.setCreatedAt(LocalDateTime.now());

            repository.save(newRestaurantOrder);
        } catch (Exception e) {
            throw new RuntimeException("Cannot save RestaurantOrder :" + e);
        }
    }
//
//    @Override
//    public RestaurantOrder updateStatus(UUID orderId, UUID restaurantId, OrderStatus status) {
//        RestaurantOrderJpaEntity orderEntity = findByOrderIdAndRestaurantId(orderId, restaurantId);
//
//        orderEntity.setStatus(status.toString());
//
//        return mapper.toDomain(repository.save(orderEntity));
//    }

    @Override
    public RestaurantOrder findByOrderIdAndRestaurantId(UUID orderId, UUID restaurantId) {
        return repository.findByOrderIdAndRestaurantId(orderId, restaurantId)
                .map(mapper::toDomain)
                .orElseThrow(() -> new RuntimeException(("Cannot find Restaurant Order")));
    }

    @Override
    public void updateStatus(RestaurantOrder order) {
        RestaurantJpaEntity restaurant = restaurantJpaRepository.getReferenceById(order.getRestaurantId());
        RestaurantOrderJpaEntity newRestaurantOrder = mapper.toEntity(order);
        newRestaurantOrder.setRestaurant(restaurant);
        repository.save(newRestaurantOrder);
    }

}
