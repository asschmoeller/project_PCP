package com.example.pcpImatik.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity 
public class OrdemProducao{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long tempoPrevisto;
    @ManyToOne (cascade = {CascadeType.MERGE,
        CascadeType.REFRESH})
    private Produto produto;
    @ManyToOne (cascade = {CascadeType.MERGE,
        CascadeType.REFRESH})
    private Equipamento equipamento;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    @NotBlank
    private String status;
    @NotNull
    private int quantidade;
    @ManyToOne (cascade = {CascadeType.MERGE,
        CascadeType.REFRESH})
    private Operador operador;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getTempoPrevisto() {
        return tempoPrevisto;
    }
    public void setTempoPrevisto(long tempoPrevisto) {
        this.tempoPrevisto = tempoPrevisto;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public Equipamento getEquipamento() {
        return equipamento;
    }
    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }
    public LocalDate getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }
    public LocalDate getDataFim() {
        return dataFim;
    }
    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public Operador getOperador() {
        return operador;
    }
    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    
}