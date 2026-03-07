package com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "menu_items")
public class MenuItemJpaEntity {
    @Id
    private UUID id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Boolean available;

    @Column
    private Double price;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    private RestaurantJpaEntity restaurant;
}
