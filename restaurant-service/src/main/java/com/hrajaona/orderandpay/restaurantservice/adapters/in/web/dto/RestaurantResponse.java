package com.hrajaona.orderandpay.restaurantservice.adapters.in.web.dto;

import com.hrajaona.orderandpay.restaurantservice.domain.model.MenuItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantResponse {
    private String restaurantIdf;
    private List<MenuItem> menuItems;
    private String name;
    private String phoneNumber;
    private String address;
    private String emailAddress;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
