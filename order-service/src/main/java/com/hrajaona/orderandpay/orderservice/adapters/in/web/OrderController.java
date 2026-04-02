package com.hrajaona.orderandpay.orderservice.adapters.in.web;

import com.hrajaona.orderandpay.orderservice.adapters.in.web.dto.OrderRequest;
import com.hrajaona.orderandpay.orderservice.adapters.out.client.address.AddressClient;
import com.hrajaona.orderandpay.orderservice.adapters.out.client.address.AddressResponseDto;
import com.hrajaona.orderandpay.orderservice.adapters.out.client.restaurant.RestaurantClient;
import com.hrajaona.orderandpay.orderservice.adapters.out.client.restaurant.RestaurantResponseDto;
import com.hrajaona.orderandpay.orderservice.application.service.OrderService;
import com.hrajaona.orderandpay.orderservice.domain.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final AddressClient addressClient;
    private final RestaurantClient restaurantClient;

    @PostMapping
    public ResponseEntity<Map<String, String>> createOrder(@RequestBody OrderRequest orderRequest) {
        String correlationId = UUID.randomUUID().toString();

        orderService.create(orderRequest, correlationId);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Order initiated");
        response.put("correlationId", correlationId);

        return ResponseEntity.ok(response);
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

}
