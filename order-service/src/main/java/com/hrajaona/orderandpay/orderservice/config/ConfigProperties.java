package com.hrajaona.orderandpay.orderservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ConfigProperties {
    @Value("${host.user-service}")
    private String userServiceHost;
}
