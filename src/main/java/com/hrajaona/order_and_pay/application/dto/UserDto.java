package com.hrajaona.order_and_pay.application.dto;

import com.hrajaona.order_and_pay.shared.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String userIdf;
    private String userName;
    private String phoneNumber;
    private String emailAddress;
    private Role role;
    private AddressDto address;
    private LocalDateTime creationDate;
}
