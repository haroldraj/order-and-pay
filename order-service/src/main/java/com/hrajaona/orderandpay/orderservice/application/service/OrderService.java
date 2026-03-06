package com.hrajaona.orderandpay.orderservice.application.service;

import com.hrajaona.orderandpay.orderservice.adapters.in.web.dto.OrderRequest;
import com.hrajaona.orderandpay.orderservice.adapters.in.web.mapper.OrderWebMapper;
import com.hrajaona.orderandpay.orderservice.application.port.in.OrderUseCase;
import com.hrajaona.orderandpay.orderservice.application.port.out.OrderRepository;
import com.hrajaona.orderandpay.orderservice.domain.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService implements OrderUseCase {
    private final OrderWebMapper orderWebMapper;
    private final OrderRepository orderRepository;

    @Override
    public String createOrder(OrderRequest orderRequest) {

        return "Ok";
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
