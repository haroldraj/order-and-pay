package com.hrajaona.orderandpay.userservice.adapters.out.persistence.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "users")
public class UserJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private UUID userIdf;

    @Column
    private String userName;

    @Column
    private String phoneNumber;

    @Column
    private String emailAddress;

    @Column
    private String status;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<AddressJpa> addresses;

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private Set<RoleJpa> roles;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserJpa userJpa = (UserJpa) o;
        return Objects.equals(id, userJpa.id) && Objects.equals(userIdf, userJpa.userIdf) && Objects.equals(userName, userJpa.userName) && Objects.equals(phoneNumber, userJpa.phoneNumber) && Objects.equals(emailAddress, userJpa.emailAddress) && Objects.equals(status, userJpa.status) && Objects.equals(createdAt, userJpa.createdAt) && Objects.equals(updatedAt, userJpa.updatedAt) && Objects.equals(addresses, userJpa.addresses) && Objects.equals(roles, userJpa.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userIdf, userName, phoneNumber, emailAddress, status, createdAt, updatedAt, addresses, roles);
    }
}
