package com.hrajaona.orderandpay.userservice.adapters.mapper;

import com.hrajaona.orderandpay.userservice.adapters.out.persistence.jpa.UserJpa;
import com.hrajaona.orderandpay.userservice.application.dto.UserRequest;
import com.hrajaona.orderandpay.userservice.application.dto.UserResponse;
import com.hrajaona.orderandpay.userservice.domain.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RoleMapper.class, AddressMapper.class})
public interface UserMapper {
    UserJpa domainToJpa(User user);
    User jpaToDomain(UserJpa userJpa);
    UserResponse domainToResponse(User user);
    User requestToDomain(UserRequest userRequest);
    List<User> jpaToDomainList(List<UserJpa> userJpaList);
    List<UserResponse> domainToResponseList(List<User> userList);
}
