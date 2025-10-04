package com.hrajaona.order_and_pay.adapters.out.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "deliveries")
@Getter
@Setter
public class DeliveryJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String deliveryIdf;

    @Column
    private LocalDateTime pickUpTime;

    @Column
    private LocalDateTime deliveryTime;

    @Column
    private String status;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserJpa deliveryUserJpa;

    @OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private OrderJpa deliveryOrderJpa;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryJpa that = (DeliveryJpa) o;
        return Objects.equals(id, that.id) && Objects.equals(deliveryIdf, that.deliveryIdf) && Objects.equals(pickUpTime, that.pickUpTime) && Objects.equals(deliveryTime, that.deliveryTime) && Objects.equals(status, that.status) && Objects.equals(deliveryUserJpa, that.deliveryUserJpa) && Objects.equals(deliveryOrderJpa, that.deliveryOrderJpa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deliveryIdf, pickUpTime, deliveryTime, status, deliveryUserJpa, deliveryOrderJpa);
    }
}
