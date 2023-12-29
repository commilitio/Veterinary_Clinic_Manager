package com.alexander.vetclinicmanager.model;

import java.math.BigDecimal;

public enum Procedure {

    INJECTION_SC("Injection subcutaneous", BigDecimal.valueOf(10.0)),
    INJECTION_IM("Injection intramuscular", BigDecimal.valueOf(15.0)),
    INJECTION_IV("Injection intravenous", BigDecimal.valueOf(20.0));

    private final String name;
    private final BigDecimal price;

    Procedure(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}


















