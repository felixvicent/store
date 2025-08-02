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
@Table(name = "orders")
@SequenceGenerator(name = "seq_orders", sequenceName = "seq_orders", allocationSize = 1)
public class Order implements Serializable {

    @Serial
    static private final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_orders")
    private Long id;

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(
            name = "person_id",
            nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_order_person")
    )
    private Person person;

    @ManyToOne
    @JoinColumn(
            name = "delivery_address_id",
            nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_order_delivery_address")
    )
    private Address deliveryAddress;

    @ManyToOne
    @JoinColumn(
            name = "billing_address_id",
            nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_order_billing_address")
    )
    private Address billingAddress;

    @Column(nullable = false)
    private BigDecimal totalValue;

    private BigDecimal discountValue;

    @ManyToOne
    @JoinColumn(
            name = "payment_method_id",
            nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_order_payment_method")
    )
    private PaymentMethod paymentMethod;

    @OneToOne
    @JoinColumn(
            name = "sale_invoice_id",
            nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_order_sale_invoice")
    )
    private SalesInvoice salesInvoice;

    @ManyToOne
    @JoinColumn(
            name = "discount_coupon_id",
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_order_discount_coupon")
    )
    private DiscountCoupon discountCoupon;

    @Column(nullable = false)
    private BigDecimal shippingValue;

    @Column(nullable = false)
    private Integer shippingTimeInDays;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date saleDate;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;
}
