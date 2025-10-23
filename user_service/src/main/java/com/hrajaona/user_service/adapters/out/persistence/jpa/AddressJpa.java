package com.hrajaona.user_service.adapters.out.persistence.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "addresses")
public class AddressJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private UUID addressIdf;

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
    @JoinColumn(name= "user_id")
    private UserJpa user;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AddressJpa that = (AddressJpa) o;
        return Objects.equals(id, that.id) && Objects.equals(addressIdf, that.addressIdf) && Objects.equals(label, that.label) && Objects.equals(street, that.street) && Objects.equals(houseNumber, that.houseNumber) && Objects.equals(city, that.city) && Objects.equals(postalCode, that.postalCode) && Objects.equals(country, that.country) && Objects.equals(isDefault, that.isDefault) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, addressIdf, label, street, houseNumber, city, postalCode, country, isDefault, createdAt, updatedAt, user);
    }
}
