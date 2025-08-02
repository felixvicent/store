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
@Table(name = "discount_coupons")
@SequenceGenerator(name = "seq_discount_coupons", sequenceName = "seq_discount_coupons", allocationSize = 1)
public class DiscountCoupon implements Serializable {

    @Serial
    static private final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_discount_coupons")
    private Long id;

    @Column(nullable = false)
    private String code;

    private BigDecimal realValue;

    private BigDecimal percentageValue;

    @Temporal(TemporalType.DATE)
    private Date expirationDate;
}
