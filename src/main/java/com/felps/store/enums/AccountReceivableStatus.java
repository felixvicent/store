package com.felps.store.enums;


public enum AccountReceivableStatus {
    CHARGE("Pagar"),
    OVERDUE("Venancio"),
    OPEN("Alberta"),
    PAID("quited");

    final String description;

    AccountReceivableStatus(String description) {
        this.description = description;
    }
}
