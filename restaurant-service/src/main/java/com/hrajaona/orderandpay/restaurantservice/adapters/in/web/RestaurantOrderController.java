package com.hrajaona.orderandpay.restaurantservice.adapters.in.web;

import com.hrajaona.orderandpay.restaurantservice.adapters.in.web.request.PrepareOrderRequest;
import com.hrajaona.orderandpay.restaurantservice.application.port.in.PrepareOrderUseCase;
import com.hrajaona.orderandpay.restaurantservice.application.port.in.command.PrepareOrderCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/restaurants/orders")
@RequiredArgsConstructor
public class RestaurantOrderController {
    private final PrepareOrderUseCase prepareOrderUseCase;

    @PostMapping("/preparing")
    public ResponseEntity<Void> markAsPreparing(@RequestBody PrepareOrderRequest request) {
        PrepareOrderCommand command = new PrepareOrderCommand(request.getOrderId(), request.getRestaurantId());
        prepareOrderUseCase.execute(command);

        return ResponseEntity.noContent().build();
    }
}
