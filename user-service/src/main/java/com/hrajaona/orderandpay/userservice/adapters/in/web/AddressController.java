package com.hrajaona.orderandpay.userservice.adapters.in.web;

import com.hrajaona.orderandpay.userservice.application.service.AddressService;
import com.hrajaona.orderandpay.userservice.domain.model.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable ("id") UUID id) {
        return ResponseEntity.ok((addressService.getAddressById(id)));
    }
}
