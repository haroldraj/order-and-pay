package com.hrajaona.orderandpay.orderservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "services")
@Getter
@Setter
public class ServicesProperties {
    private Address address;
    private Restaurant restaurant;

    @Getter
    @Setter
    public static class Address{
        private String baseUrl;
        private Endpoints endpoints;
    }

    @Getter
    @Setter
    public static class Restaurant{
        private String baseUrl;
        private Endpoints endpoints;
    }

    @Getter
    @Setter
    public static class Endpoints{
        private String getAddress;
        private String getRestaurant;
    }
}
