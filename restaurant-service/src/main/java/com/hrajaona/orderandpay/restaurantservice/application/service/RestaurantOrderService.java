package com.hrajaona.orderandpay.restaurantservice.application.service;

import com.hrajaona.library.enums.OrderStatus;
import com.hrajaona.library.events.OrderReadyForDeliveryEvent;
import com.hrajaona.library.model.RestaurantSnapshot;
import com.hrajaona.orderandpay.restaurantservice.application.mapper.RestaurantOrderApplicationMapper;
import com.hrajaona.orderandpay.restaurantservice.application.port.in.PrepareOrderUseCase;
import com.hrajaona.orderandpay.restaurantservice.application.port.in.ReadyForDeliveryOrderUseCase;
import com.hrajaona.orderandpay.restaurantservice.application.port.in.command.PrepareOrderCommand;
import com.hrajaona.orderandpay.restaurantservice.application.port.in.command.ReadyForDeliveryOrderCommand;
import com.hrajaona.orderandpay.restaurantservice.application.port.out.OrderEventProducerPort;
import com.hrajaona.orderandpay.restaurantservice.application.port.out.RestaurantOrderRepositoryPort;
import com.hrajaona.orderandpay.restaurantservice.application.port.out.RestaurantOrderStatusHistoryPort;
import com.hrajaona.orderandpay.restaurantservice.application.port.out.RestaurantRepositoryPort;
import com.hrajaona.orderandpay.restaurantservice.domain.mapper.RestaurantSnapshotMapper;
import com.hrajaona.orderandpay.restaurantservice.domain.model.Restaurant;
import com.hrajaona.orderandpay.restaurantservice.domain.model.RestaurantOrder;
import com.hrajaona.orderandpay.restaurantservice.domain.model.RestaurantOrderStatusHistory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestaurantOrderService implements PrepareOrderUseCase, ReadyForDeliveryOrderUseCase {
    private final RestaurantOrderRepositoryPort restaurantOrderRepositoryPort;
    private final RestaurantOrderStatusHistoryPort restaurantOrderStatusHistoryPort;
    private final OrderEventProducerPort orderEventProducerPort;
    private final RestaurantOrderApplicationMapper applicationMapper;
    private final RestaurantRepositoryPort restaurantRepositoryPort;
    private final RestaurantSnapshotMapper restaurantSnapshotMapper;


    @Override
    @Transactional
    public void execute(PrepareOrderCommand command) {
        RestaurantOrder order = restaurantOrderRepositoryPort.findByOrderIdAndRestaurantId(
                command.getOrderId(), command.getRestaurantId());

        OrderStatus previousStatus = order.getStatus();
        order.markAsPreparing();
        updateOrderStatus(order, previousStatus);

        orderEventProducerPort.publishOrderPreparing( applicationMapper.toOrderPreparingEvent(order), order.getCorrelationId());

    }

    @Override
    @Transactional
    public void execute(ReadyForDeliveryOrderCommand command) {
        RestaurantOrder order = restaurantOrderRepositoryPort.findByOrderIdAndRestaurantId(
                command.getOrderId(), command.getRestaurantId());

        OrderStatus previousStatus = order.getStatus();
        order.markAsReadyForDelivery();

        updateOrderStatus(order, previousStatus);

        OrderReadyForDeliveryEvent orderReadyForDeliveryEvent =  applicationMapper.toOrderReadyForDeliveryEvent(order);

        orderReadyForDeliveryEvent.setRestaurantSnapshot(getRestaurantSnapshot(order.getRestaurantId()));

        orderEventProducerPort.publishOrderReadyForDelivery(orderReadyForDeliveryEvent, order.getCorrelationId());
    }


    private void updateOrderStatus(RestaurantOrder order, OrderStatus previousStatus) {

        restaurantOrderRepositoryPort.updateStatus(order);

        saveOrderPreviousStatus(order, previousStatus);
    }

    private void saveOrderPreviousStatus(RestaurantOrder order, OrderStatus previousStatus) {
        RestaurantOrderStatusHistory orderStatusHistory = new RestaurantOrderStatusHistory();
        orderStatusHistory.setOrderId(order.getId());
        orderStatusHistory.setPreviousStatus(previousStatus);
        orderStatusHistory.setNewStatus(order.getStatus());
        orderStatusHistory.setChangedAt(order.getUpdatedAt());

        restaurantOrderStatusHistoryPort.save(orderStatusHistory);
    }

    private RestaurantSnapshot getRestaurantSnapshot(UUID restaurantId) {
        Restaurant restaurant = restaurantRepositoryPort.findById(restaurantId);

        return  restaurantSnapshotMapper.toSnapshot(restaurant);
    }


}
