package com.hrajaona.orderandpay.restaurantservice.adapters;

import com.hrajaona.orderandpay.restaurantservice.adapters.in.web.dto.RestaurantResponse;
import com.hrajaona.orderandpay.restaurantservice.application.service.RestaurantService;
import com.hrajaona.orderandpay.restaurantservice.domain.model.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/restaurants")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<RestaurantResponse>> getAllRestaurants() {
        return ResponseEntity.ok(restaurantService.loadAllRestaurants());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Restaurant> getRestaurantById(@PathVariable ("id") UUID id) {
        return ResponseEntity.ok(restaurantService.getRestaurantById(id));
    }
}
