package com.hrajaona.orderandpay.paymentservice.config;

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
    private String paymentEvents;

    @Bean
    public NewTopic paymentEventsTopic() {
        return TopicBuilder.name(paymentEvents).build();
    }
}
