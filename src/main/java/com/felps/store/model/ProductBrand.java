package com.felps.store.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "product_brands")
@SequenceGenerator(name = "seq_product_brands", sequenceName = "seq_product_brands", allocationSize = 1)
public class ProductBrand implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product_brands")
    private Long id;

    @Column(nullable = false)
    private String name;
}
