package com.hrajaona.user_service.adapters.mapper;

import com.hrajaona.user_service.adapters.out.persistence.jpa.RoleJpa;
import com.hrajaona.user_service.domain.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface RoleMapper {
    RoleJpa domainToJpa(Role role);
    Role jpaToDomain(RoleJpa roleJpa);
}
