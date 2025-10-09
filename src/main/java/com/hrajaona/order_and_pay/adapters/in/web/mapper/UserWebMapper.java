package com.hrajaona.order_and_pay.adapters.in.web.mapper;

import com.hrajaona.order_and_pay.adapters.in.web.model.request.UserRequest;
import com.hrajaona.order_and_pay.adapters.in.web.model.response.UserResponse;
import com.hrajaona.order_and_pay.application.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserWebMapper {
    UserDto toDto(UserRequest userRequest);
    UserResponse toResponse(UserDto userDto);
}
