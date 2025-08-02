package com.felps.store.enums;

public enum AccountPaymentStatus {
    CHARGE("Pagar"),
    OVERDUE("Venancio"),
    OPEN("Alberta"),
    PAID("quited");

    final String description;

    AccountPaymentStatus(String description) {
        this.description = description;
    }
}