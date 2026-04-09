package com.hrajaona.orderandpay.orderservice.config;

import lombok.Getter;
import lombok.Setter;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@ConfigurationProperties(prefix = "kafka.topics")
@Getter
@Setter
public class KafkaTopicsConfig {
    private String orderCreated;
    private String orderPaid;
    private String paymentCompleted;
    private String paymentFailed;
    private String deliveryCreated;
    private String deliveryCompleted;

    @Bean
    public NewTopic orderCreatedTopic() {
        return TopicBuilder.name(orderCreated).build();
    }

    @Bean
    public NewTopic orderPaidTopic() {
        return TopicBuilder.name(orderPaid).build();
    }
}
