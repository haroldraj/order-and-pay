package com.hrajaona.orderandpay.orderservice.application.service;

import com.hrajaona.library.enums.DeliveryStatus;
import com.hrajaona.library.enums.OrderStatus;
import com.hrajaona.library.enums.PaymentStatus;
import com.hrajaona.library.model.AddressSnapshot;
import com.hrajaona.orderandpay.orderservice.adapters.in.web.dto.OrderRequest;
import com.hrajaona.orderandpay.orderservice.adapters.in.web.mapper.OrderItemWebMapper;
import com.hrajaona.orderandpay.orderservice.adapters.out.client.address.AddressClient;
import com.hrajaona.orderandpay.orderservice.adapters.out.client.mapper.AddressClientMapper;
import com.hrajaona.orderandpay.orderservice.adapters.out.client.mapper.RestaurantClientMapper;
import com.hrajaona.orderandpay.orderservice.adapters.out.client.restaurant.RestaurantClient;
import com.hrajaona.orderandpay.orderservice.adapters.out.client.restaurant.RestaurantResponseDto;
import com.hrajaona.orderandpay.orderservice.adapters.out.kafka.mapper.OrderEventMapper;
import com.hrajaona.orderandpay.orderservice.application.port.in.OrderUseCase;
import com.hrajaona.orderandpay.orderservice.application.port.out.OrderEventProducerPort;
import com.hrajaona.orderandpay.orderservice.application.port.out.OrderRepositoryPort;
import com.hrajaona.orderandpay.orderservice.domain.model.Order;
import com.hrajaona.orderandpay.orderservice.domain.model.OrderItem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService implements OrderUseCase {
    private final OrderRepositoryPort orderRepositoryPort;
    private final AddressClient addressClient;
    private final AddressClientMapper  addressClientMapper;
    private final RestaurantClient restaurantClient;
    private final RestaurantClientMapper restaurantClientMapper;
    private final OrderItemWebMapper orderItemWebMapper;
    private final OrderEventProducerPort orderEventProducerPort;
    private final OrderEventMapper  orderEventMapper;

    @Override
    public List<Order> getAllOrders() {
        return orderRepositoryPort.findAll();
    }

    @Override
    public Order create(OrderRequest orderRequest, String correlationId) {
        AddressSnapshot address =  addressClient.getAddress(orderRequest.getAddressId());
        RestaurantResponseDto restaurant = restaurantClient.getRestaurant(orderRequest.getRestaurantId());

        Order order = Order.builder()
                .addressId(orderRequest.getAddressId())
                .userId(orderRequest.getUserId())
                .restaurantId(orderRequest.getRestaurantId())
                .amount(orderRequest.getAmount())
                .orderItems(new ArrayList<>())
                .deliveryStatus(DeliveryStatus.NOT_STARTED)
                .status(OrderStatus.PENDING_PAYMENT)
                .paymentStatus(PaymentStatus.PENDING)
                .valueDate(LocalDateTime.now())
                .addressSnapshot(address)
                .restaurantSnapshot(restaurantClientMapper.toDomain(restaurant))
                .build();

        List<OrderItem> orderItems = orderItemWebMapper.toDomainList(orderRequest.getOrderItems());

        Order savedOrder = orderRepositoryPort.update(order, orderItems);

        orderEventProducerPort.publishOrderCreated(orderEventMapper.toEvent(savedOrder), correlationId);

        return savedOrder;

    }
}
