package com.hrajaona.orderandpay.restaurantservice.application.service;

import com.hrajaona.orderandpay.restaurantservice.application.port.in.PrepareOrderUseCase;
import com.hrajaona.orderandpay.restaurantservice.application.port.in.RestaurantOrderUseCase;
import com.hrajaona.orderandpay.restaurantservice.application.port.in.command.PrepareOrderCommand;
import com.hrajaona.orderandpay.restaurantservice.application.port.out.RestaurantOrderRepositoryPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestaurantOrderService implements RestaurantOrderUseCase, PrepareOrderUseCase {
    private final RestaurantOrderRepositoryPort restaurantOrderRepository;

    @Override
    @Transactional
    public void markAsPreparing(PrepareOrderCommand command) {

    }

    @Override
    public void execute(PrepareOrderCommand command) {
        log.info("Prepare Order Request");
    }
}
