package com.hrajaona.order_and_pay.adapters.out.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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
    private UserJpa orderUserJpa;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private RestaurantJpa orderRestaurantJpa;

    @OneToOne(mappedBy = "deliveryOrderJpa", cascade = CascadeType.ALL, orphanRemoval = true)
    private DeliveryJpa deliveryJpa;

    @OneToOne(mappedBy = "paymentOrderJpa", cascade = CascadeType.ALL, orphanRemoval = true)
    private PaymentJpa paymentJpa;

    @OneToMany(mappedBy = "orderItemOrderJpa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItemJpa> orderItemJpaList;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderJpa orderJpa = (OrderJpa) o;
        return Float.compare(totalAmount, orderJpa.totalAmount) == 0 && Objects.equals(id, orderJpa.id) && Objects.equals(orderIdf, orderJpa.orderIdf) && Objects.equals(status, orderJpa.status) && Objects.equals(creationDate, orderJpa.creationDate) && Objects.equals(orderUserJpa, orderJpa.orderUserJpa) && Objects.equals(orderRestaurantJpa, orderJpa.orderRestaurantJpa) && Objects.equals(deliveryJpa, orderJpa.deliveryJpa) && Objects.equals(paymentJpa, orderJpa.paymentJpa) && Objects.equals(orderItemJpaList, orderJpa.orderItemJpaList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderIdf, totalAmount, status, creationDate, orderUserJpa, orderRestaurantJpa, deliveryJpa, paymentJpa, orderItemJpaList);
    }
}
