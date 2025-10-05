package com.hrajaona.order_and_pay.adapters.in.response;

import com.hrajaona.order_and_pay.domain.model.Address;
import com.hrajaona.order_and_pay.shared.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private String userIdf;
    private String userName;
    private String phoneNumber;
    private String emailAddress;
    private Role role;
    private Address userAddress;
    private LocalDateTime creationDate;
}
