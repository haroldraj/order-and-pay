package com.hrajaona.order_and_pay.adapters.out.persistence;

import com.hrajaona.order_and_pay.domain.model.User;
import com.hrajaona.order_and_pay.domain.port.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRpositoryAdapter implements UserRepository {

//    private final User
//
//    @Override
//    @Transactional(readOnly = true)
//    public List<User> findAll() {
//        return
//    }
}
