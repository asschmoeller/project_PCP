package com.example.pcpImatik.entity;

public enum UnidadeMedida {
    KG("kg"),
    G("g"),
    L("litro"),
    M("metro"),
    CM("centímetro");

    private final String label;

    UnidadeMedida(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}


