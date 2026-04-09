package com.hrajaona.orderandpay.orderservice.adapters.out.client.user;

import com.hrajaona.orderandpay.orderservice.config.ServicesProperties;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RequiredArgsConstructor
@Setter
@Component
public class UserClient {
    private final RestTemplate restTemplate;
    private final ServicesProperties servicesProperties;

    public UserResponseDto getUser(UUID id) {
        String url = servicesProperties.getUser().getBaseUrl()
                + servicesProperties.getUser().getEndpoints().getGetUser();

        return restTemplate.getForObject(url, UserResponseDto.class, id);
    }

}
