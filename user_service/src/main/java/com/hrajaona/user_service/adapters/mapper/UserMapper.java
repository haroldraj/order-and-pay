package com.hrajaona.user_service.adapters.mapper;

import com.hrajaona.user_service.adapters.out.persistence.jpa.UserJpa;
import com.hrajaona.user_service.application.dto.UserRequest;
import com.hrajaona.user_service.application.dto.UserResponse;
import com.hrajaona.user_service.domain.model.User;
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
