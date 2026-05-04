package com.hrajaona.orderandpay.deliveryservice.application.handler;

import com.hrajaona.library.events.OrderReadyForDeliveryEvent;
import com.hrajaona.orderandpay.deliveryservice.application.port.in.HandleOrderReadyUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderReadyForDeliveryHandler implements HandleOrderReadyUseCase {
    @Override
    public void handle(OrderReadyForDeliveryEvent order, String correlationId) {
      log.info("Handle OrderReadyDorDeliveryEvent");
    }
}
