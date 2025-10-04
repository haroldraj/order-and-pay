package com.hrajaona.order_and_pay.adapters.out.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "order_items")
@Getter
@Setter
public class OrderItemJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String orderItemIdf;

    @Column
    private Integer quantity;

    @Column
    private float unitPrice;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderJpa orderItemOrderJpa;

    @ManyToOne
    @JoinColumn(name = "menu_item_id")
    private MenuItemJpa orderItemMenuItemJpa;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemJpa that = (OrderItemJpa) o;
        return Float.compare(unitPrice, that.unitPrice) == 0 && Objects.equals(id, that.id) && Objects.equals(orderItemIdf, that.orderItemIdf) && Objects.equals(quantity, that.quantity) && Objects.equals(orderItemOrderJpa, that.orderItemOrderJpa) && Objects.equals(orderItemMenuItemJpa, that.orderItemMenuItemJpa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderItemIdf, quantity, unitPrice, orderItemOrderJpa, orderItemMenuItemJpa);
    }
}
