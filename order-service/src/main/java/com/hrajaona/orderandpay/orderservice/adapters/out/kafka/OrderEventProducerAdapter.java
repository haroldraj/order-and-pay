package com.hrajaona.orderandpay.orderservice.adapters.out.kafka;

import com.hrajaona.library.events.OrderCreatedEvent;
import com.hrajaona.library.events.OrderPaidEvent;
import com.hrajaona.library.model.CustomerSnapshot;
import com.hrajaona.orderandpay.orderservice.adapters.out.client.user.UserClient;
import com.hrajaona.orderandpay.orderservice.adapters.out.client.user.UserResponseDto;
import com.hrajaona.orderandpay.orderservice.adapters.out.kafka.mapper.OrderEventMapper;
import com.hrajaona.orderandpay.orderservice.application.port.out.OrderEventProducerPort;
import com.hrajaona.orderandpay.orderservice.domain.model.Order;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@Getter
@Setter
@RequiredArgsConstructor
public class OrderEventProducerAdapter implements OrderEventProducerPort {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final OrderEventMapper orderEventMapper;
    private final UserClient userClient;
    private final String ORDER_CREATED = "ORDER_CREATED";
    private final String ORDER_SERVICE = "ORDER_SERVICE";
    private final String ORDER_PAID = "ORDER_PAID";

    @Override
    public void publishOrderCreated(OrderCreatedEvent orderCreatedEvent, String correlationId) {

        UUID eventId = UUID.randomUUID();
        orderCreatedEvent.setEventId(eventId);

        log.info("Sending OrderCreatedEvent with correlationId={} and eventId= {}", correlationId, eventId);

        ProducerRecord<String, Object> record = new ProducerRecord<>("order.created", orderCreatedEvent.getOrderId().toString(), orderCreatedEvent);

        addHeaders(record, correlationId, eventId.toString(), ORDER_CREATED);

        kafkaTemplate.send(record);
    }

    @Override
    public void publishOrderPaid(Order order, String correlationId) {
        UUID eventId = UUID.randomUUID();
        UserResponseDto userResponseDto = userClient.getUser(order.getUserId());
        OrderPaidEvent orderPaidEvent = getOrderPaidEvent(order, userResponseDto, eventId);

        log.info("Sending OrderPaidEvent with correlationId={} and eventId= {}", correlationId, eventId);

        ProducerRecord<String, Object> record = new ProducerRecord<>("order.paid", orderPaidEvent.getOrderId().toString(), orderPaidEvent);

        addHeaders(record, correlationId, eventId.toString(), ORDER_PAID);

        kafkaTemplate.send(record);
    }

    private OrderPaidEvent getOrderPaidEvent(Order order, UserResponseDto userResponseDto, UUID eventId) {
        CustomerSnapshot customerSnapshot = new CustomerSnapshot(userResponseDto.getUserName(), userResponseDto.getPhoneNumber());

        return new OrderPaidEvent(
                eventId,
                order.getId(),
                order.getAmount(),
                order.getValueDate(),
                order.getRestaurantId(),
                customerSnapshot,
                order.getAddressSnapshot(),
            null,
//
//                orderEventMapper.itemToPayloadList(order.getOrderItems()),
                null);
    }

    private void addHeaders(ProducerRecord<String, Object> record, String correlationId, String eventId, String eventType) {
        record.headers().add("correlationId", correlationId.getBytes());
        record.headers().add("eventType", eventType.getBytes());
        record.headers().add("eventId", eventId.getBytes());
        record.headers().add("producer", ORDER_SERVICE.getBytes());
    }
}