package com.hrajaona.orderandpay.userservice.adapters.in.web.dto;

import com.hrajaona.library.enums.RoleType;
import com.hrajaona.orderandpay.userservice.domain.model.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
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
    private List<Address> addresses;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
