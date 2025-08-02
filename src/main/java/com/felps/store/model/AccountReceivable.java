package com.felps.store.model;

import com.felps.store.enums.AccountReceivableStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "accounts_receivable")
@SequenceGenerator(name = "seq_accounts_receivable", sequenceName = "seq_accounts_receivable", allocationSize = 1)
public class AccountReceivable implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_accounts_receivable")
    private Long id;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountReceivableStatus status;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dueDate;

    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    @Column(nullable = false)
    private BigDecimal totalValue;

    private BigDecimal discountValue;

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(
            name = "person_id",
            nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_accounts_receivable_person")
    )
    private Person person;
}
