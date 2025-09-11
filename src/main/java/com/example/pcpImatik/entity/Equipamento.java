package com.example.pcpImatik.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity 
public class Equipamento{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String nomeEquipamento;
    @ManyToMany
    @JoinTable(
        name = "equipamento_produto",
        joinColumns = @JoinColumn(name = "equipamento_id"),
        inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private Set<Produto> produtos;
    @NotNull
    private long capacidadeProdutiva;
    @NotBlank
    private String status;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNomeEquipamento() {
        return nomeEquipamento;
    }
    public void setNomeEquipamento(String nomeEquipamento) {
        this.nomeEquipamento = nomeEquipamento;
    }
    public long getCapacidadeProdutiva() {
        return capacidadeProdutiva;
    }
    public void setCapacidadeProdutiva(long capacidadeProdutiva) {
        this.capacidadeProdutiva = capacidadeProdutiva;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Set<Produto> getProdutos() {
        return produtos;
    }
    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }
}