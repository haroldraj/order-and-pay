package com.hrajaona.orderandpay.orderservice.adapters.out.client.restaurant;

import com.hrajaona.orderandpay.orderservice.config.ServicesProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RestaurantClient {
    private final RestTemplate restTemplate;
    private final ServicesProperties servicesProperties;

    public RestaurantResponseDto getRestaurant(UUID id) {
        String url = servicesProperties.getRestaurant().getBaseUrl()
                + servicesProperties.getRestaurant().getEndpoints().getGetRestaurant();

        return restTemplate.getForObject(url, RestaurantResponseDto.class, id);
    }
}
