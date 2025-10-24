package com.hrajaona.orderandpay.userservice.application.dto;

import com.hrajaona.library.enums.RoleType;
import com.hrajaona.orderandpay.userservice.domain.model.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private UUID userIdf;
    private String userName;
    private String phoneNumber;
    private String emailAddress;
    private String status;
    private RoleType role;
    private Set<Address> addresses;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
