package com.hrajaona.orderandpay.orderservice.adapters.out.client.address;

import com.hrajaona.orderandpay.orderservice.config.ServicesProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressClient {
    private final RestTemplate restTemplate;
    private final ServicesProperties servicesProperties;

    public AddressResponseDto getAddress(UUID addressId) {
        String url = servicesProperties.getAddress().getBaseUrl()
                + servicesProperties.getAddress().getEndpoints().getGetAddress();

        return restTemplate.getForObject(url, AddressResponseDto.class, addressId);

    }
}
