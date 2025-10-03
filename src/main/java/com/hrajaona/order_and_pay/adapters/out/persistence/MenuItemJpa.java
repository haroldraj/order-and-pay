package com.hrajaona.order_and_pay.adapters.out.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

}
