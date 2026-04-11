package com.hrajaona.orderandpay.paymentservice.application.service.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Service
public class OrderEventProcessor {
    private final Map<String, OrderEventHandler<?>> handlers;

    public OrderEventProcessor(List<OrderEventHandler<?>> handlerList) {
        this.handlers = handlerList.stream()
                .collect(Collectors.toMap(OrderEventHandler::support, Function.identity()));
    }

    public void process(Object event, String eventType, String correlationId) {
        OrderEventHandler<?> handler = handlers.get(eventType);

        if (handler == null) {
            throw new RuntimeException("Unknown EventType " + eventType + " with correlationId " + correlationId);
        }

        dispatch(handler, event, correlationId);
    }


    @SuppressWarnings("unchecked")
    private <T> void dispatch(OrderEventHandler<?> rawHandler, Object event, String correlationId) {
        OrderEventHandler<T> handler = (OrderEventHandler<T>) rawHandler;
        handler.handle((T) event, correlationId);
    }
}
