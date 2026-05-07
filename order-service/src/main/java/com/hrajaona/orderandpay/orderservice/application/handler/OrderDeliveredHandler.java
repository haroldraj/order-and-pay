package com.hrajaona.orderandpay.orderservice.application.handler;

import com.hrajaona.library.enums.OrderEvent;
import com.hrajaona.library.enums.OrderStatus;
import com.hrajaona.library.events.OrderDeliveredEvent;
import com.hrajaona.orderandpay.orderservice.application.port.in.OrderDeliveredUseCase;
import com.hrajaona.orderandpay.orderservice.application.port.out.OrderRepositoryPort;
import com.hrajaona.orderandpay.orderservice.application.port.out.OrderStatusHistoryRepositoryPort;
import com.hrajaona.orderandpay.orderservice.domain.model.Order;
import com.hrajaona.orderandpay.orderservice.domain.model.OrderStatusHistory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderDeliveredHandler implements OrderDeliveredUseCase {
    private final OrderRepositoryPort orderRepositoryPort;
    private final OrderStatusHistoryRepositoryPort orderStatusHistoryRepositoryPort;

    @Override
    @Transactional
    public void handle(OrderDeliveredEvent orderDeliveredEvent, String correlationId) {
        Order order = orderRepositoryPort.findByIdAndRestaurantId(orderDeliveredEvent.getOrderId(), orderDeliveredEvent.getRestaurantId());

        OrderStatus orderPreviousStatus = order.getStatus();

        order.markAsDelivered();

        orderRepositoryPort.update(order);

        saveOrderPreviousStatus(order, orderPreviousStatus);

        log.info("{} event processed successfully.", OrderEvent.ORDER_DELIVERED);
    }

    private void saveOrderPreviousStatus(Order order, OrderStatus previousStatus) {
        OrderStatusHistory orderStatusHistory = new OrderStatusHistory();
        orderStatusHistory.setOrderId(order.getId());
        orderStatusHistory.setPreviousStatus(previousStatus);
        orderStatusHistory.setStatus(order.getStatus());
        orderStatusHistory.setChangedAt(order.getUpdatedAt());

        orderStatusHistoryRepositoryPort.save(orderStatusHistory);
    }
}
