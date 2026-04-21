package com.hrajaona.orderandpay.restaurantservice.application.service;

import com.hrajaona.library.enums.OrderStatus;
import com.hrajaona.orderandpay.restaurantservice.application.port.in.PrepareOrderUseCase;
import com.hrajaona.orderandpay.restaurantservice.application.port.in.ReadyForDeliveryOrderUseCase;
import com.hrajaona.orderandpay.restaurantservice.application.port.in.command.PrepareOrderCommand;
import com.hrajaona.orderandpay.restaurantservice.application.port.in.command.ReadyForDeliveryOrderCommand;
import com.hrajaona.orderandpay.restaurantservice.application.port.out.RestaurantOrderRepositoryPort;
import com.hrajaona.orderandpay.restaurantservice.application.port.out.RestaurantOrderStatusHistoryPort;
import com.hrajaona.orderandpay.restaurantservice.domain.model.RestaurantOrder;
import com.hrajaona.orderandpay.restaurantservice.domain.model.RestaurantOrderStatusHistory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestaurantOrderService implements PrepareOrderUseCase, ReadyForDeliveryOrderUseCase {
    private final RestaurantOrderRepositoryPort restaurantOrderRepositoryPort;
    private final RestaurantOrderStatusHistoryPort restaurantOrderStatusHistoryPort;


    @Override
    @Transactional
    public void execute(PrepareOrderCommand command) {
        RestaurantOrder order = restaurantOrderRepositoryPort.findByOrderIdAndRestaurantId(
                command.getOrderId(), command.getRestaurantId()
        );

        updateOrderStatus(order, OrderStatus.PREPARING);

    }

    @Override
    @Transactional
    public void execute(ReadyForDeliveryOrderCommand command) {
        RestaurantOrder order = restaurantOrderRepositoryPort.findByOrderIdAndRestaurantId(
                command.getOrderId(), command.getRestaurantId()
        );

        updateOrderStatus(order, OrderStatus.READY_FOR_DELIVERY);
    }


    private void updateOrderStatus(RestaurantOrder order, OrderStatus newStatus) {

        OrderStatus previousStatus = order.getStatus();

        order.setStatus(newStatus);

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

}
