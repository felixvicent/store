package com.felps.store.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "invoice_item_products")
@SequenceGenerator(name = "seq_invoice_item_products", sequenceName = "seq_invoice_item_products", allocationSize = 1)
public class InvoiceItemProduct implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_invoice_item_products")
    private Long id;

    @Column(nullable = false)
    private double quantity;

    @ManyToOne
    @JoinColumn(
            name = "product_id",
            nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_invoice_item_product_product")
    )
    private Product product;

    @ManyToOne
    @JoinColumn(
            name = "purchase_invoice_id",
            nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_invoice_item_product_purchase_invoice"))
    private PurchaseInvoice purchaseInvoice;

}
