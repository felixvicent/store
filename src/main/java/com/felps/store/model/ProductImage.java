package com.felps.store.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "product_images")
@SequenceGenerator(name = "seq_product_images", sequenceName = "seq_product_images", allocationSize = 1)
public class ProductImage implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product_images")
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String originalImage;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String miniatureImage;

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(
            name = "product_id",
            nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_product_image_product")
    )
    private Product product;
}
