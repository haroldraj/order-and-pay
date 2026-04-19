package com.hrajaona.orderandpay.deliveryservice.application.service;

import com.hrajaona.library.events.OrderReadyForDeliveryEvent;
import com.hrajaona.orderandpay.deliveryservice.application.port.in.HandleOrderReadyUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class HandleOrderReadyService implements HandleOrderReadyUseCase {

    @Override
    public void handle(OrderReadyForDeliveryEvent order, String correlationId) {
        log.info("Handle OrderReadyForDeliveryEvent with correlationId={}", correlationId);
    }
}
