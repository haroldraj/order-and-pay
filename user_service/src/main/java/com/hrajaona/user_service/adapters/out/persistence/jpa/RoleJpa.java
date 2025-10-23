package com.hrajaona.user_service.adapters.out.persistence.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "roles")
public class RoleJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private UUID roleIdf;

    @Column
    private String roleName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<UserJpa> users;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RoleJpa roleJpa = (RoleJpa) o;
        return Objects.equals(id, roleJpa.id) && Objects.equals(roleIdf, roleJpa.roleIdf) && Objects.equals(roleName, roleJpa.roleName) && Objects.equals(users, roleJpa.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleIdf, roleName, users);
    }
}
