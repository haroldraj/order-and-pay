package com.hrajaona.orderandpay.orderservice.application.port.in;

import com.hrajaona.orderandpay.orderservice.adapters.in.web.dto.OrderRequest;
import org.springframework.stereotype.Component;

@Component
public interface OrderUseCase {
    String createOrder(OrderRequest orderRequest);
}
