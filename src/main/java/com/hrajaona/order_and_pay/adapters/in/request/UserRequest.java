package com.hrajaona.order_and_pay.adapters.in.request;

import com.hrajaona.order_and_pay.domain.model.Address;
import com.hrajaona.order_and_pay.shared.enums.Role;
import jakarta.validation.constraints.Email;

public record UserRequest(
        String userName,
        String phoneNumber,
        @Email String emailAddress,
        Role role,
        Address userAddress
)
{}
