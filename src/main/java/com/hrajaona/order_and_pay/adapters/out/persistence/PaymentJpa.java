package com.hrajaona.order_and_pay.adapters.out.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "payments")
@Getter
@Setter
public class PaymentJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String paymentIdf;

    @Column
    private LocalDateTime valueDate;

    @Column
    private String status;

    @Column
    private float amount;

    @Column
    private String method;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserJpa paymentUserJpa;

    @OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private OrderJpa paymentOrderJpa;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PaymentJpa that = (PaymentJpa) o;
        return Float.compare(amount, that.amount) == 0 && Objects.equals(id, that.id) && Objects.equals(paymentIdf, that.paymentIdf) && Objects.equals(valueDate, that.valueDate) && Objects.equals(status, that.status) && Objects.equals(method, that.method) && Objects.equals(paymentUserJpa, that.paymentUserJpa) && Objects.equals(paymentOrderJpa, that.paymentOrderJpa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, paymentIdf, valueDate, status, amount, method, paymentUserJpa, paymentOrderJpa);
    }

}
