package com.hrajaona.orderandpay.userservice.adapters.in.web;

import com.hrajaona.orderandpay.userservice.adapters.in.web.dto.UserRequest;
import com.hrajaona.orderandpay.userservice.application.service.UserService;
import com.hrajaona.orderandpay.userservice.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/search")
    public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.addUser(userRequest));
    }

    @GetMapping("/{id}")
    public  ResponseEntity<User> getUserById(@PathVariable ("id") UUID id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

}
