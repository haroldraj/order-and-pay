package com.hrajaona.order_and_pay.adapters.in.web.controller;

import com.hrajaona.order_and_pay.adapters.in.web.model.request.UserRequest;
import com.hrajaona.order_and_pay.adapters.in.web.model.response.UserResponse;
import com.hrajaona.order_and_pay.application.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> userResponseList = userService.getAllUsersList();
        return ResponseEntity.ok(userResponseList);
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(new UserResponse());
    }

}
