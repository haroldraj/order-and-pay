package com.hrajaona.orderandpay.restaurantservice.application.handler;

import com.hrajaona.library.enums.OrderStatus;
import com.hrajaona.library.events.OrderPaidEvent;
import com.hrajaona.library.events.OrderReadyForDeliveryEvent;
import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.RestaurantOrderPersistenceAdapter;
import com.hrajaona.orderandpay.restaurantservice.application.mapper.RestaurantOrderApplicationMapper;
import com.hrajaona.orderandpay.restaurantservice.application.port.in.HandleOrderPaidUseCase;
import com.hrajaona.orderandpay.restaurantservice.application.port.out.OrderEventProducerPort;
import com.hrajaona.orderandpay.restaurantservice.application.port.out.RestaurantRepositoryPort;
import com.hrajaona.orderandpay.restaurantservice.domain.model.RestaurantOrder;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrderPaidHandler implements HandleOrderPaidUseCase {
    private final OrderEventProducerPort orderEventProducerPort;
    private final RestaurantOrderApplicationMapper restaurantOrderApplicationMapper;
    private final RestaurantOrderPersistenceAdapter restaurantOrderPersistenceAdapter;
    private final RestaurantRepositoryPort restaurantRepositoryPort;

    @Override
    @Transactional
    public void handle(OrderPaidEvent orderPaidEvent, String correlationId) {
        RestaurantOrder order = restaurantOrderApplicationMapper.toDomain(orderPaidEvent);

        order.setCorrelationId(correlationId);

        order.markAsPaid();

        restaurantOrderPersistenceAdapter.save(order);

//        OrderReadyForDeliveryEvent orderReadyForDeliveryEvent = orderApplicationMapper.toOrderReadyForDelivery(orderPaidEvent);
//
//        orderEventProducerPort.publishOrderReadyForDelivery(orderReadyForDeliveryEvent, correlationId);
    }
}
