package com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.mapper;

import com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.entity.MenuItemJpaEntity;
import com.hrajaona.orderandpay.restaurantservice.domain.model.MenuItem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MenuItemPersistenceMapper {
    MenuItemJpaEntity toJpa(MenuItem menuItem);
    MenuItem toDomain(MenuItemJpaEntity menuItemJpaEntity);
}
