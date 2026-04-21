package com.hrajaona.orderandpay.orderservice.application.handler;

import com.hrajaona.library.enums.OrderStatus;
import com.hrajaona.library.events.OrderPaidEvent;
import com.hrajaona.library.events.PaymentCompletedEvent;
import com.hrajaona.library.model.CustomerSnapshot;
import com.hrajaona.orderandpay.orderservice.adapters.out.client.user.UserClient;
import com.hrajaona.orderandpay.orderservice.application.mapper.OrderApplicationMapper;
import com.hrajaona.orderandpay.orderservice.application.port.in.PaymentCompletedUseCase;
import com.hrajaona.orderandpay.orderservice.application.port.out.OrderEventProducerPort;
import com.hrajaona.orderandpay.orderservice.application.port.out.OrderRepositoryPort;
import com.hrajaona.orderandpay.orderservice.application.port.out.OrderStatusHistoryRepositoryPort;
import com.hrajaona.orderandpay.orderservice.domain.model.Order;
import com.hrajaona.orderandpay.orderservice.domain.model.OrderStatusHistory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentCompletedHandler implements PaymentCompletedUseCase {
    private final OrderRepositoryPort orderRepositoryPort;
    private final OrderApplicationMapper  orderApplicationMapper;
    private final OrderEventProducerPort orderEventProducerPort;
    private final UserClient userClient;
    private final OrderStatusHistoryRepositoryPort orderStatusHistoryRepositoryPort;

    @Override
    @Transactional
    public void handle(PaymentCompletedEvent event, String correlationId) {
        Order order = orderRepositoryPort.findByIdAndUserId(event.getOrderId(), event.getUserId());
        OrderStatus orderPreviousStatus = order.getStatus();

        order.markAsPaid();

        orderRepositoryPort.update(order);

        saveOrderPreviousStatus(order, orderPreviousStatus);

        OrderPaidEvent orderPaidEvent = orderApplicationMapper.toOrderPaidEvent(order);

        CustomerSnapshot customer = userClient.getUser(order.getUserId());

        orderPaidEvent.setCustomer(customer);

        orderEventProducerPort.publishOrderPaid(orderPaidEvent, correlationId);

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
