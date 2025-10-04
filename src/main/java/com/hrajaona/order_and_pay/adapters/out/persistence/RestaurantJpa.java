package com.hrajaona.order_and_pay.adapters.out.persistence;

import com.hrajaona.order_and_pay.shared.adapters.out.persistence.embeddable.AddressEmbeddable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "restaurants")
@Getter
@Setter
public class RestaurantJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String restaurantIdf;

    @Column
    private String restaurantName;

    @Embedded
    @AttributeOverride(name = "street", column = @Column(name = "addr_street"))
    @AttributeOverride(name = "house", column = @Column(name = "addr_house"))
    @AttributeOverride(name = "box", column = @Column(name = "addr_box"))
    @AttributeOverride(name = "city", column = @Column(name = "addr_city"))
    @AttributeOverride(name = "postal_code", column = @Column(name = "addr_street"))
    @AttributeOverride(name = "country", column = @Column(name = "addr_country"))
    private AddressEmbeddable addressEmbeddable;

    @OneToMany(mappedBy = "menuItemRestaurantJpa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MenuItemJpa> menuItemJpaList;

    @OneToMany(mappedBy = "orderRestaurantJpa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderJpa> orderJpaList;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantJpa that = (RestaurantJpa) o;
        return Objects.equals(id, that.id) && Objects.equals(restaurantIdf, that.restaurantIdf) && Objects.equals(restaurantName, that.restaurantName) && Objects.equals(addressEmbeddable, that.addressEmbeddable) && Objects.equals(menuItemJpaList, that.menuItemJpaList) && Objects.equals(orderJpaList, that.orderJpaList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, restaurantIdf, restaurantName, addressEmbeddable, menuItemJpaList, orderJpaList);
    }
}
