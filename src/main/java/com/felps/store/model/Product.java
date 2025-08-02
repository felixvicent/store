package com.felps.store.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "products")
@SequenceGenerator(name = "seq_products", sequenceName = "seq_products", allocationSize = 1)
public class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_products")
    private Long id;

    @Column(nullable = false)
    private String unitType;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT", length = 2000, nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean active = Boolean.TRUE;

    @Column(nullable = false)
    private Double weight;

    @Column(nullable = false)
    private Double width;

    @Column(nullable = false)
    private Double height;

    @Column(nullable = false)
    private Double length;

    @Column(nullable = false)
    private BigDecimal value = BigDecimal.ZERO;

    @Column(nullable = false)
    private Integer quantity = 0;

    private Integer alertQuantity = 0;

    private String youtubeLink;

    private Boolean lowQuantityAlert = Boolean.FALSE;

    private Integer hits = 0;
}
