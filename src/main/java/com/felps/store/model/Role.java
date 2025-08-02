package com.felps.store.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serial;

@Getter
@Setter
@Entity
@Table(name = "roles")
@SequenceGenerator(name = "seq_roles", sequenceName = "seq_roles", allocationSize = 1)
public class Role implements GrantedAuthority {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_roles")
    private Long id;

    @Column(nullable = false)
    private String description;

    @Override
    public String getAuthority() {
        return this.description;
    }
}
