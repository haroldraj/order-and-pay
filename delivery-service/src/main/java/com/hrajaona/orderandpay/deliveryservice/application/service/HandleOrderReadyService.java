package com.hrajaona.orderandpay.deliveryservice.application.service;

import com.hrajaona.library.events.OrderReadyForDelivery;
import com.hrajaona.orderandpay.deliveryservice.application.port.in.HandleOrderReadyUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class HandleOrderReadyService implements HandleOrderReadyUseCase {

    @Override
    public void handle(OrderReadyForDelivery order, String correlationId) {
        log.info("Handle OrderReadyForDelivery with correlationId={}", correlationId);
    }
}
