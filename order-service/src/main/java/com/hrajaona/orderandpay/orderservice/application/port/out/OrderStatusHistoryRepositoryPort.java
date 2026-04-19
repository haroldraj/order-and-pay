package com.hrajaona.orderandpay.orderservice.application.port.out;

import com.hrajaona.orderandpay.orderservice.domain.model.OrderStatusHistory;

public interface OrderStatusHistoryRepositoryPort {
    void save(OrderStatusHistory orderStatusHistory);
}
