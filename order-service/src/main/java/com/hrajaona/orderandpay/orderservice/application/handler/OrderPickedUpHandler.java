package com.hrajaona.orderandpay.orderservice.application.handler;

import com.hrajaona.library.enums.OrderEvent;
import com.hrajaona.library.enums.OrderStatus;
import com.hrajaona.library.events.OrderPickedUpEvent;
import com.hrajaona.orderandpay.orderservice.application.port.in.OrderPickedUpUseCase;
import com.hrajaona.orderandpay.orderservice.application.port.out.OrderRepositoryPort;
import com.hrajaona.orderandpay.orderservice.application.port.out.OrderStatusHistoryRepositoryPort;
import com.hrajaona.orderandpay.orderservice.domain.model.Order;
import com.hrajaona.orderandpay.orderservice.domain.model.OrderStatusHistory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrderPickedUpHandler implements OrderPickedUpUseCase {
    private final OrderRepositoryPort orderRepositoryPort;
    private final OrderStatusHistoryRepositoryPort orderStatusHistoryRepositoryPort;

    @Override
    @Transactional
    public void handle(OrderPickedUpEvent orderPickedUpEvent, String correlationId) {
        Order order = orderRepositoryPort.findByIdAndRestaurantId(orderPickedUpEvent.getOrderId(), orderPickedUpEvent.getRestaurantId());

        OrderStatus orderPreviousStatus = order.getStatus();

        order.markAsPickedUp();

        orderRepositoryPort.update(order);

        saveOrderPreviousStatus(order, orderPreviousStatus);

        log.info("{} event processed successfully.", OrderEvent.ORDER_PICKED_UP);
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
