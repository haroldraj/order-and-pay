package com.hrajaona.orderandpay.orderservice.adapters.out.persistence;

import com.hrajaona.orderandpay.orderservice.adapters.out.persistence.entity.OrderJpaEntity;
import com.hrajaona.orderandpay.orderservice.adapters.out.persistence.mapper.OrderItemPersistenceMapper;
import com.hrajaona.orderandpay.orderservice.adapters.out.persistence.mapper.OrderPersistenceMapper;
import com.hrajaona.orderandpay.orderservice.adapters.out.persistence.repository.OrderJpaRepository;
import com.hrajaona.orderandpay.orderservice.application.port.out.OrderRepository;
import com.hrajaona.orderandpay.orderservice.domain.model.Order;
import com.hrajaona.orderandpay.orderservice.domain.model.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class OrderPersistenceAdapter implements OrderRepository {
    private final OrderJpaRepository orderJpaRepository;
    private final OrderPersistenceMapper orderPersistenceMapper;
    private final OrderItemPersistenceMapper orderItemPersistenceMapper;

    @Override
    public List<Order> findAll() {
        return orderJpaRepository.findAll()
                .stream()
                .map(orderPersistenceMapper::toDomain)
                .toList();
    }

    @Override
    public Order findByIdAndUserId(UUID id, UUID userId) {
        return orderJpaRepository.findByIdAndUserId(id, userId)
                .map(orderPersistenceMapper::toDomain)
                .orElseThrow(() -> new RuntimeException("Order with id " + id + "not found"));
    }

    @Override
    public Order save(Order order, List<OrderItem> orderItems) {
        try{
            OrderJpaEntity newOrder = orderPersistenceMapper.toEntity(order);
            newOrder.addOrderItems(orderItemPersistenceMapper.toEntities(orderItems));

            OrderJpaEntity savedOrder = orderJpaRepository.save(newOrder);
            return  orderPersistenceMapper.toDomain(savedOrder);
        }
        catch (Exception ex){
            throw new RuntimeException("Cannot save order | "+ex);
        }
    }

    @Override
    public Order findByIdAndUserIdAndAmount(UUID id, UUID userId, BigDecimal amount) {
        return orderJpaRepository.findByIdAndUserIdAndAmount(id, userId, amount)
                .map(orderPersistenceMapper::toDomain)
                .orElseThrow(() -> new RuntimeException("Order with id="+id+" not found"));
    }

    @Override
    public void save(Order order) {
        orderJpaRepository.save(orderPersistenceMapper.toEntity(order));
    }
}
