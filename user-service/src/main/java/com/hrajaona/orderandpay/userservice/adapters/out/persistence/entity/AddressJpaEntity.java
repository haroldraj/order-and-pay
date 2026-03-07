package com.hrajaona.orderandpay.userservice.adapters.out.persistence.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "addresses")
public class AddressJpaEntity {
    @Id
    private UUID id;

    @Column
    private String label;

    @Column
    private String street;

    @Column
    private String houseNumber;

    @Column
    private String city;

    @Column
    private Integer postalCode;

    @Column
    private String country;

    @Column
    private Boolean isDefault;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "user_id", referencedColumnName = "id")
    private UserJpaEntity user;
}
