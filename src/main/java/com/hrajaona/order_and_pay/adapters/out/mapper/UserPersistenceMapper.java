package com.hrajaona.order_and_pay.adapters.out.mapper;

import com.hrajaona.order_and_pay.adapters.out.persistence.UserJpa;
import com.hrajaona.order_and_pay.domain.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserPersistenceMapper {
    UserJpa toJpa(User user);
    User toDomain(UserJpa userJpa);
}
