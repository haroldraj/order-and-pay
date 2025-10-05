package com.hrajaona.order_and_pay.domain.model;

import com.hrajaona.order_and_pay.adapters.in.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends UserResponse {
    private Long id;

}
