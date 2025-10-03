package com.hrajaona.order_and_pay.adapters.out.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class OrderJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String orderIdf;

    @Column
    private float totalAmount;

    @Column
    private String status;

    @Column
    private LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserJpa userJpa;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private RestaurantJpa orderRestaurantJpa;

}
