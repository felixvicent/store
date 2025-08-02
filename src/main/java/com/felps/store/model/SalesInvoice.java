package com.felps.store.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "sales_invoices")
@SequenceGenerator(name = "seq_sales_invoices", sequenceName = "seq_sales_invoices", allocationSize = 1)
public class SalesInvoice implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_sales_invoices")
    private Long id;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String serie;

    @Column(nullable = false)
    private String type;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String xml;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String pdf;

    @OneToOne
    @JoinColumn(
            name = "order_id",
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_sales_invoice_order")
    )
    private Order order;

}
