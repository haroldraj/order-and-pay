package com.hrajaona.order_and_pay.adapters.in.request;


import com.hrajaona.order_and_pay.domain.model.Address;
import com.hrajaona.order_and_pay.shared.enums.Role;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String userName;
    private String phoneNumber;
    @Email
    private String emailAddress;
    private Role role;
    private Address userAddress;
}
