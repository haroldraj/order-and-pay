package com.hrajaona.order_and_pay.adapters.out.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "menu_items")
@Getter
@Setter
public class MenuItemJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String menuItemIdf;

    @Column
    private String menuName;

    @Column
    private float price;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private RestaurantJpa menuItemRestaurantJpa;

    @OneToMany(mappedBy = "orderItemMenuItemJpa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItemJpa> orderItemJpaList;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MenuItemJpa that = (MenuItemJpa) o;
        return Float.compare(price, that.price) == 0 && Objects.equals(id, that.id) && Objects.equals(menuItemIdf, that.menuItemIdf) && Objects.equals(menuName, that.menuName) && Objects.equals(menuItemRestaurantJpa, that.menuItemRestaurantJpa) && Objects.equals(orderItemJpaList, that.orderItemJpaList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, menuItemIdf, menuName, price, menuItemRestaurantJpa, orderItemJpaList);
    }
}
