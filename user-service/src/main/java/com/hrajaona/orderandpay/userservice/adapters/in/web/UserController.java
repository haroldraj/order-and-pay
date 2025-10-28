package com.hrajaona.orderandpay.userservice.adapters.in.web;

import com.hrajaona.orderandpay.userservice.adapters.in.web.dto.UserRequest;
import com.hrajaona.orderandpay.userservice.adapters.in.web.dto.UserResponse;
import com.hrajaona.orderandpay.userservice.application.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userServiceImpl;

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userServiceImpl.getAllUsers());
    }

    @GetMapping("/search")
    public ResponseEntity<UserResponse> getUserByEmail(@RequestParam String email) {
        return ResponseEntity.ok(userServiceImpl.getUserByEmail(email));
    }

    @PostMapping
    public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userServiceImpl.addUser(userRequest));
    }

}
