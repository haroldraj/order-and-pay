package com.hrajaona.orderandpay.orderservice.application.service;

import com.hrajaona.library.enums.DeliveryStatus;
import com.hrajaona.library.enums.OrderStatus;
import com.hrajaona.library.enums.PaymentStatus;
import com.hrajaona.orderandpay.orderservice.adapters.in.web.dto.OrderRequest;
import com.hrajaona.orderandpay.orderservice.adapters.out.client.address.AddressClient;
import com.hrajaona.orderandpay.orderservice.adapters.out.client.address.AddressResponseDto;
import com.hrajaona.orderandpay.orderservice.adapters.out.client.mapper.AddressClientMapper;
import com.hrajaona.orderandpay.orderservice.adapters.out.client.mapper.RestaurantClientMapper;
import com.hrajaona.orderandpay.orderservice.adapters.out.client.restaurant.RestaurantClient;
import com.hrajaona.orderandpay.orderservice.adapters.out.client.restaurant.RestaurantResponseDto;
import com.hrajaona.orderandpay.orderservice.application.port.in.OrderUseCase;
import com.hrajaona.orderandpay.orderservice.application.port.out.OrderRepository;
import com.hrajaona.orderandpay.orderservice.domain.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService implements OrderUseCase {
    private final OrderRepository orderRepository;
    private final AddressClient addressClient;
    private final AddressClientMapper  addressClientMapper;
    private final RestaurantClient restaurantClient;
    private final RestaurantClientMapper restaurantClientMapper;

    @Override
    public List<Order> getAllOrders() {
        UUID id = UUID.fromString("28d53f6d-dedf-4789-8184-82b28d1fa6e1");
        AddressResponseDto address =  addressClient.getAddress(id);

        log.info(address.getCountry());
        return orderRepository.findAll();
    }

    @Override
    public Order create(OrderRequest orderRequest) {
        AddressResponseDto address =  addressClient.getAddress(orderRequest.getAddressId());
        RestaurantResponseDto restaurant = restaurantClient.getRestaurant(orderRequest.getRestaurantId());

        log.info(address.toString());

        Order order = Order.builder()
                .id(UUID.randomUUID())
                .updatedAt(LocalDateTime.now())
                .addressId(orderRequest.getAddressId())
                .userId(orderRequest.getUserId())
                .restaurantId(orderRequest.getRestaurantId())
                .totalAmount(orderRequest.getTotalAmount())
                .orderItems(orderRequest.getOrderItems())
                .deliveryStatus(DeliveryStatus.NOT_STARTED)
                .status(OrderStatus.PENDING_PAYMENT)
                .paymentStatus(PaymentStatus.PENDING)
                .valueDate(LocalDateTime.now())
                .addressSnapshot(addressClientMapper.toDomain(address))
                .restaurantSnapshot(restaurantClientMapper.toDomain(restaurant))
                .build();
        return orderRepository.save(order);
    }
}
