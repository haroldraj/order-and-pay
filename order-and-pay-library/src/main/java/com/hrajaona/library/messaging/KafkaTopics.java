package com.hrajaona.library.messaging;

public class KafkaTopics {
    public static final String ORDER_CREATED = "order.created";
    public static final String ORDER_PAID = "order.paid";
    public static final String ORDER_PREPARING = "order.preparing";
    public static final String ORDER_READY_FOR_DELIVERY = "order.ready-for-delivery";
    public static final String ORDER_PICKED_UP = "order.picked-up";
    public static final String ORDER_DELIVERED = "order.delivered";
    public static final String PAYMENT_COMPLETED = "payment.completed";
    public static final String PAYMENT_FAILED = "payment.failed";

    public KafkaTopics() {
    }
}
