package com.felps.store.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

@Getter
@Setter
@Entity
@Table(name = "legal_persons")

public class LegalPerson extends Person {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private String stateRegistration;

    private String cityRegistration;

    @Column(nullable = false)
    private String fantasyName;

    @Column(nullable = false)
    private String companyName;

    private String category;

}
