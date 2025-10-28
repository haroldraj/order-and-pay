package com.hrajaona.orderandpay.userservice.adapters.out.persistence.mapper;

import com.hrajaona.orderandpay.userservice.adapters.out.persistence.entity.UserJpa;
import com.hrajaona.orderandpay.userservice.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {AddressPersistenceMapper.class})
public interface UserPersistenceMapper {

    UserJpa toJpa(User user);
    User toDomain(UserJpa userJpa);

}
