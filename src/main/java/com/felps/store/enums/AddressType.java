package com.felps.store.enums;

public enum AddressType {
    SHIPPING("Entrega"),
    BILLING("Cobrança");

    final String description;

    AddressType(String description) {
        this.description = description;
    }
}
