package com.example.pcpImatik.entity;

public enum TipoManFerramenta {
    Nenhuma("Nenhuma"),
    Preventiva("Preventiva"),
    Corretiva("Corretiva"),
    InspecaoTecnica("Inspeção Técnica"),
    Substituicao("Substituição"),
    Outra("Outra");

    private final String label;

    TipoManFerramenta(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}


