package com.hrajaona.order_and_pay.application.mapper;

import com.hrajaona.order_and_pay.application.dto.UserDto;
import com.hrajaona.order_and_pay.domain.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDto toDto(User user);
    User toDomain(UserDto userDto);
}
