package com.hrajaona.orderandpay.orderservice.application.handler;

import com.hrajaona.library.events.OrderPaidEvent;
import com.hrajaona.library.events.PaymentCompletedEvent;
import com.hrajaona.library.model.AddressSnapshot;
import com.hrajaona.library.model.CustomerSnapshot;
import com.hrajaona.orderandpay.orderservice.adapters.out.client.address.AddressClient;
import com.hrajaona.orderandpay.orderservice.adapters.out.client.user.UserClient;
import com.hrajaona.orderandpay.orderservice.application.mapper.OrderApplicationMapper;
import com.hrajaona.orderandpay.orderservice.application.port.in.PaymentCompletedUseCase;
import com.hrajaona.orderandpay.orderservice.application.port.out.OrderEventProducerPort;
import com.hrajaona.orderandpay.orderservice.application.port.out.OrderRepository;
import com.hrajaona.orderandpay.orderservice.domain.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentCompletedHandler implements PaymentCompletedUseCase {
    private final OrderRepository orderRepository;
    private final OrderApplicationMapper  orderApplicationMapper;
    private final OrderEventProducerPort orderEventProducerPort;
    private final UserClient userClient;
    private final AddressClient addressClient;

    @Override
    public void handle(PaymentCompletedEvent event, String correlationId) {
        Order order = orderRepository.findByIdAndUserId(event.getOrderId(), event.getUserId());
        order.markAsPaid();

        orderRepository.save(order);

        OrderPaidEvent orderPaidEvent = orderApplicationMapper.toOrderPaidEvent(order);

        CustomerSnapshot customer = userClient.getUser(order.getUserId());
//        AddressSnapshot deliveryAddress = addressClient.getAddress(order.getAddressId());

        orderPaidEvent.setCustomer(customer);
//        orderPaidEvent.setDeliveryAddress(deliveryAddress);

        orderEventProducerPort.publishOrderPaid(orderApplicationMapper.toOrderPaidEvent(order), correlationId);

    }
}
