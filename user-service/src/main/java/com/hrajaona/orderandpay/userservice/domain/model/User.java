package com.hrajaona.orderandpay.userservice.domain.model;

import com.hrajaona.library.enums.RoleType;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
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
    private List<Address> addresses;
    private RoleType role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
