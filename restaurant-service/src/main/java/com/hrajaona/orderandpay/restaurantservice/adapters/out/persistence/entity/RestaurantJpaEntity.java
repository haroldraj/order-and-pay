package com.hrajaona.orderandpay.restaurantservice.adapters.out.persistence.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "restaurants")
public class RestaurantJpaEntity {
    @Id
    private UUID id;

    @Column
    private String name;

    @Column
    private String phoneNumber;

    @Column
    private String emailAddress;

    @Column
    private String address;

    @Column
    private String status;

    @Column
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MenuItemJpaEntity> menuItems;

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
    private List<RestaurantOrderJpaEntity> restaurantOrder;
}
