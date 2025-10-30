package com.hrajaona.orderandpay.orderservice.application.service;

import com.hrajaona.orderandpay.orderservice.adapters.in.web.dto.OrderRequest;
import com.hrajaona.orderandpay.orderservice.adapters.in.web.mapper.OrderWebMapper;
import com.hrajaona.orderandpay.orderservice.application.port.in.OrderUseCase;
import com.hrajaona.orderandpay.orderservice.domain.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService implements OrderUseCase {
    private final OrderWebMapper orderWebMapper;

    @Override
    public String createOrder(OrderRequest orderRequest) {
        Order order = orderWebMapper.toDomain(orderRequest);
        order.setOrderIdf(UUID.randomUUID());

        return "Ok";
    }
}
