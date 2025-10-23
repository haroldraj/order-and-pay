package com.hrajaona.orderandpay.userservice.adapters.mapper;

import com.hrajaona.orderandpay.userservice.adapters.out.persistence.jpa.RoleJpa;
import com.hrajaona.orderandpay.userservice.domain.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface RoleMapper {
    RoleJpa domainToJpa(Role role);
    Role jpaToDomain(RoleJpa roleJpa);
}
