package com.hrajaona.orderandpay.orderservice.adapters.in.web;

import com.hrajaona.orderandpay.orderservice.adapters.in.web.dto.OrderRequest;
import com.hrajaona.orderandpay.orderservice.application.service.OrderService;
import com.hrajaona.orderandpay.orderservice.domain.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest orderRequest) {
        return ResponseEntity.ok(orderService.create(orderRequest));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

}
