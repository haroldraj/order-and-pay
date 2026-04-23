package com.hrajaona.orderandpay.restaurantservice.adapters.in.web;

import com.hrajaona.orderandpay.restaurantservice.adapters.in.web.request.OrderCommandRequest;
import com.hrajaona.orderandpay.restaurantservice.adapters.in.web.response.OrderCommandResponse;
import com.hrajaona.orderandpay.restaurantservice.application.port.in.PrepareOrderUseCase;
import com.hrajaona.orderandpay.restaurantservice.application.port.in.ReadyForDeliveryOrderUseCase;
import com.hrajaona.orderandpay.restaurantservice.application.port.in.command.PrepareOrderCommand;
import com.hrajaona.orderandpay.restaurantservice.application.port.in.command.ReadyForDeliveryOrderCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/restaurants/orders")
@RequiredArgsConstructor
public class RestaurantOrderController {
    private final PrepareOrderUseCase prepareOrderUseCase;
    private final ReadyForDeliveryOrderUseCase readyForDeliveryOrderUseCase;

    @PostMapping("/preparing")
    public ResponseEntity<OrderCommandResponse> markAsPreparing(@RequestBody OrderCommandRequest request) {
        PrepareOrderCommand command = new PrepareOrderCommand(request.getOrderId(), request.getRestaurantId());
        prepareOrderUseCase.execute(command);

        return ResponseEntity.ok(new OrderCommandResponse("Done"));
    }

    @PostMapping("/ready-for-delivery")
    public ResponseEntity<OrderCommandResponse> markAsReadyForDelivery(@RequestBody OrderCommandRequest request) {
        ReadyForDeliveryOrderCommand command = new ReadyForDeliveryOrderCommand(request.getOrderId(), request.getRestaurantId());
        readyForDeliveryOrderUseCase.execute(command);

        return ResponseEntity.ok(new OrderCommandResponse("Done"));
    }
}
