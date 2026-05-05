package com.hrajaona.orderandpay.deliveryservice.adapters.in.web;

import com.hrajaona.orderandpay.deliveryservice.application.service.DriverService;
import com.hrajaona.orderandpay.deliveryservice.domain.model.Driver;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/drivers")
@RequiredArgsConstructor
public class DriverController {
    private final DriverService driverService;

    @GetMapping()
    public ResponseEntity<List<Driver>> getAll() {
        return ResponseEntity.ok(driverService.getAll());
    }

}
