package com.hrajaona.order_and_pay.domain.port.out;

import com.hrajaona.order_and_pay.adapters.in.request.UserRequest;
import com.hrajaona.order_and_pay.adapters.out.persistence.UserJpa;
import com.hrajaona.order_and_pay.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserJpa, Long> {
    User save (UserRequest userRequest);
}
