package com.hrajaona.order_and_pay.adapters.out.persistence;

import com.hrajaona.order_and_pay.shared.adapters.out.persistence.embeddable.AddressEmbeddable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

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

   @OneToMany(mappedBy = "userJpa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderJpa> orderJpaList;

}
