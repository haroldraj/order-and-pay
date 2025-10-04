package com.hrajaona.order_and_pay.adapters.out.persistence;

import com.hrajaona.order_and_pay.shared.adapters.out.persistence.embeddable.AddressEmbeddable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name= "users")
@Getter
@Setter
public class UserJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userIdf;

    @Column
    private String userName;

    @Column
    private String phoneNumber;

    @Column
    private String emailAddress;

    @Column
    private LocalDateTime creationDate;

    @Column
    private String role;

    @Embedded
    @AttributeOverride(name = "street", column = @Column(name = "addr_street"))
    @AttributeOverride(name = "house", column = @Column(name = "addr_house"))
    @AttributeOverride(name = "box", column = @Column(name = "addr_box"))
    @AttributeOverride(name = "city", column = @Column(name = "addr_city"))
    @AttributeOverride(name = "postal_code", column = @Column(name = "addr_street"))
    @AttributeOverride(name = "country", column = @Column(name = "addr_country"))
    private AddressEmbeddable addressEmbeddable;

    @OneToMany(mappedBy = "orderUserJpa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderJpa> orderJpaList;

    @OneToOne(mappedBy = "deliveryUserJpa", cascade = CascadeType.ALL, orphanRemoval = true)
    private DeliveryJpa deliveryJpa;

    @OneToOne(mappedBy = "paymentUserJpa", cascade = CascadeType.ALL, orphanRemoval = true)
    private PaymentJpa paymentJpa;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserJpa userJpa = (UserJpa) o;
        return Objects.equals(id, userJpa.id) && Objects.equals(userIdf, userJpa.userIdf) && Objects.equals(userName, userJpa.userName) && Objects.equals(phoneNumber, userJpa.phoneNumber) && Objects.equals(emailAddress, userJpa.emailAddress) && Objects.equals(creationDate, userJpa.creationDate) && Objects.equals(role, userJpa.role) && Objects.equals(addressEmbeddable, userJpa.addressEmbeddable) && Objects.equals(orderJpaList, userJpa.orderJpaList) && Objects.equals(deliveryJpa, userJpa.deliveryJpa) && Objects.equals(paymentJpa, userJpa.paymentJpa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userIdf, userName, phoneNumber, emailAddress, creationDate, role, addressEmbeddable, orderJpaList, deliveryJpa, paymentJpa);
    }
}
