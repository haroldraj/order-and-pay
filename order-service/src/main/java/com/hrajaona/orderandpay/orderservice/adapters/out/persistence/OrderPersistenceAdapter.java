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

import java.util.List;

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
    public Order save(Order order, List<OrderItem> orderItems) {
        try{
            OrderJpaEntity newOrder = orderPersistenceMapper.toEntity(order);
            newOrder.addOrderItems(orderItemPersistenceMapper.toEntities(orderItems));

            OrderJpaEntity savedOrder = orderJpaRepository.save(newOrder);
            return  orderPersistenceMapper.toDomain(savedOrder);
        }
        catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
