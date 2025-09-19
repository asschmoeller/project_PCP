package com.example.pcpImatik.entity;

public enum TipoFornecedor {
    MateriaPrima("Matéria-Prima"),
    MaterialIndireto("Material indireto"),
    MaterialExpediente("Material de Expediente"),
    HigieneLimpeza("Higiene e Limpeza"),
    Equipamento("Equipamento"),
    Servicos("Serviços"),
    Utilidades("Utilidades"),
    EPIs("EPIs"),
    Infraestrutura("Infraestrutura"),
    Sistemas("Sistemas");

    private final String label;

    TipoFornecedor (String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}


