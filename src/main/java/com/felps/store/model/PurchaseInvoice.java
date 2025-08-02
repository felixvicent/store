package com.felps.store.model;

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
@Table(name = "purchase_invoices")
@SequenceGenerator(name = "seq_purchase_invoices", sequenceName = "seq_purchase_invoices", allocationSize = 1)
public class PurchaseInvoice implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "seq_purchase_invoices", sequenceName = "seq_purchase_invoices", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String serie;

    private String description;

    @Column(nullable = false)
    private BigDecimal totalValue;

    private BigDecimal discountValue;

    @Column(nullable = false)
    private BigDecimal icmsValue;

    @Column(nullable = false)
    private Date purchaseDate;

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(
            name = "person_id",
            nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_purchase_invoice_person")
    )
    private Person person;

    @ManyToOne
    @JoinColumn(
            name = "account_payment_id",
            nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_purchase_invoice_account_payment")
    )
    private AccountPayable accountPayment;
}


