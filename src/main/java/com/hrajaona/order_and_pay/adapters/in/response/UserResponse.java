package com.hrajaona.order_and_pay.adapters.in.response;

import com.hrajaona.order_and_pay.adapters.in.request.UserRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse extends UserRequest {
    private String userIdf;
    private LocalDateTime creationDate;
}
