package com.hrajaona.order_and_pay.adapters.out.mapper;

import com.hrajaona.order_and_pay.adapters.in.response.UserResponse;
import com.hrajaona.order_and_pay.adapters.out.persistence.UserJpa;
import com.hrajaona.order_and_pay.domain.model.User;
import com.hrajaona.order_and_pay.shared.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private AddressMapper addressMapper;

    public UserJpa toJpa(User user) {
        UserJpa userJpa = new UserJpa();

        userJpa.setId(user.getId());
        userJpa.setUserIdf(user.getUserIdf());
        userJpa.setUserName(user.getUserName());
        userJpa.setPhoneNumber(user.getPhoneNumber());
        userJpa.setEmailAddress(user.getEmailAddress());
        userJpa.setCreationDate(user.getCreationDate());
        userJpa.setRole(user.getRole().toString());
        userJpa.setAddressEmbeddable(addressMapper.toJpa(user.getUserAddress()));

        return  userJpa;

    }

    public UserResponse toResponse(UserJpa userJpa) {
        UserResponse userResponse = new UserResponse();

        userResponse.setUserIdf(userJpa.getUserIdf());
        userResponse.setUserName(userJpa.getUserName());
        userResponse.setPhoneNumber(userJpa.getPhoneNumber());
        userResponse.setEmailAddress(userJpa.getEmailAddress());
        userResponse.setCreationDate(userJpa.getCreationDate());
        userResponse.setRole(Role.valueOf(userJpa.getRole()));
        userResponse.setUserAddress(addressMapper.toDomain(userJpa.getAddressEmbeddable()));

        return  userResponse;
    }
}
