package com.felps.store.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "payment_methods")
@SequenceGenerator(name = "seq_payment_methods", sequenceName = "seq_payment_methods", allocationSize = 1)
public class PaymentMethod implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_payment_methods")
    private Long id;

    @Column(nullable = false)
    private String description;
}
