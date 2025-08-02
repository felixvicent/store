package com.felps.store.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tracking_status")
@SequenceGenerator(name = "seq_tracking_status", sequenceName = "seq_tracking_status", allocationSize = 1)
public class TrackingStatus implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tracking_status")
    private Long id;

    private String distributionCenter;

    private String city;

    private String state;

    private String status;

    @ManyToOne
    @JoinColumn(
            name = "order_id",
            nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_tracking_status_order")
    )
    private Order order;
}
