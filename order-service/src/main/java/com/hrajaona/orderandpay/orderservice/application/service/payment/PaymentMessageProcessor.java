package com.hrajaona.orderandpay.orderservice.application.service.payment;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PaymentMessageProcessor {
    private final Map<String, PaymentEventHandler<?>> handlers;

    public PaymentMessageProcessor(List<PaymentEventHandler<?>> handlerList) {
        this.handlers = handlerList.stream()
                .collect(Collectors.toMap(PaymentEventHandler::support, Function.identity()));
    }

    public void process(Object event, String eventType, String correlationId) {
        PaymentEventHandler<?> handler = handlers.get(eventType);

        if (handler == null) {
            throw new RuntimeException("Unknown EventType " + eventType + " with correlationId " + correlationId);
        }

        dispatch(handler, event, correlationId);
    }

    @SuppressWarnings("unchecked")
    private <T> void dispatch(PaymentEventHandler<?> rawHandler, Object event, String correlationId) {
        PaymentEventHandler<T> handler = (PaymentEventHandler<T>) rawHandler;
        T castedEvent = handler.eventClass().cast(event);
        handler.handle(castedEvent, correlationId);
    }
}
