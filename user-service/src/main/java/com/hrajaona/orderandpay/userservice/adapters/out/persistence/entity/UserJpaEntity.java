package com.hrajaona.orderandpay.userservice.adapters.out.persistence.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "users")
public class UserJpaEntity {
    @Id
    private UUID id;

    @Column
    private String userName;

    @Column
    private String phoneNumber;

    @Column
    private String emailAddress;

    @Column
    private String status;

    @Column
    private String role;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<AddressJpaEntity> addresses;
}
