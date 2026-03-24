package com.hrajaona.orderandpay.orderservice.adapters.in.web;

import com.hrajaona.orderandpay.orderservice.adapters.in.web.dto.OrderRequest;
import com.hrajaona.orderandpay.orderservice.adapters.out.client.address.AddressClient;
import com.hrajaona.orderandpay.orderservice.adapters.out.client.address.AddressResponseDto;
import com.hrajaona.orderandpay.orderservice.adapters.out.client.restaurant.RestaurantClient;
import com.hrajaona.orderandpay.orderservice.adapters.out.client.restaurant.RestaurantResponseDto;
import com.hrajaona.orderandpay.orderservice.adapters.out.kafka.OrderEventProducerAdapter;
import com.hrajaona.orderandpay.orderservice.application.service.OrderService;
import com.hrajaona.orderandpay.orderservice.domain.event.OrderCreatedEvent;
import com.hrajaona.orderandpay.orderservice.domain.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final AddressClient addressClient;
    private final RestaurantClient restaurantClient;
    private final OrderEventProducerAdapter orderEventProducerAdapter;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest orderRequest) {
        return ResponseEntity.ok(orderService.create(orderRequest));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/addresses/{id}")
    public ResponseEntity<AddressResponseDto> getAddress(@PathVariable("id") UUID id) {
        return  ResponseEntity.ok(addressClient.getAddress(id));
    }

    @GetMapping("/restaurants/{id}")
    public ResponseEntity<RestaurantResponseDto> getRestaurant(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(restaurantClient.getRestaurant(id));
    }

//    @PostMapping("/orders")
//    public String placeOrder(@RequestBody OrderCreatedEvent  orderCreatedEvent) {
//        orderEventProducerAdapter.sendMessage(orderCreatedEvent);
//        return "Order placed Successfully...";
//    }

}
