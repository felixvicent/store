package com.felps.store.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "product_reviews")
@SequenceGenerator(name = "seq_product_reviews", sequenceName = "seq_product_reviews", allocationSize = 1)
public class ProductReview implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product_reviews")
    private Long id;

    @Column(nullable = false)
    private Integer review;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(
            name = "person_id",
            nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_product_review_person")
    )
    private Person person;

    @ManyToOne
    @JoinColumn(
            name = "product_id",
            nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_product_review_product")
    )
    private Product product;
}
