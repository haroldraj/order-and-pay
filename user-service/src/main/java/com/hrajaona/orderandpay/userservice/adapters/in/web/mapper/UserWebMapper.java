package com.hrajaona.orderandpay.userservice.adapters.in.web.mapper;

import com.hrajaona.orderandpay.userservice.adapters.in.web.dto.UserRequest;
import com.hrajaona.orderandpay.userservice.adapters.in.web.dto.UserResponse;
import com.hrajaona.orderandpay.userservice.domain.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserWebMapper {
    UserResponse toResponse(User user);
    User toDomain(UserRequest userRequest);
}
