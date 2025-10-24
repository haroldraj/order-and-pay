package com.hrajaona.orderandpay.userservice.domain.model;

import com.hrajaona.library.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private UUID userIdf;
    private String userName;
    private String phoneNumber;
    private String emailAddress;
    private String status;
    private Set<Address> addresses;
    private RoleType role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
