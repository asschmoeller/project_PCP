package com.example.pcpImatik.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity 
public class OrdemProducao{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long tempoPrevisto;
    private long idProduto; //esse do produto
    private String equipamento;  //esse do equipamento
    private String materiaPrima; //esse da matéria prima
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String status; //ver como coloca opção
    private int quantidade;
    private String operador; //esse do operador

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
    public long getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }
    public String getEquipamento() {
        return equipamento;
    }
    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }
    public String getMateriaPrima() {
        return materiaPrima;
    }
    public void setMateriaPrima(String materiaPrima) {
        this.materiaPrima = materiaPrima;
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
    public String getOperador() {
        return operador;
    }
    public void setOperador(String operador) {
        this.operador = operador;
    }
}