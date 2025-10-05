package com.hrajaona.order_and_pay.domain.port.out;

import com.hrajaona.order_and_pay.adapters.out.persistence.MenuItemJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItemJpa, Long> {
}
