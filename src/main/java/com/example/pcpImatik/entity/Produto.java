package com.example.pcpImatik.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity 
public class Produto{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String nomeProduto;
    private String descricao;
    @NotNull (message = "A Unidade de medida é obrigatória e deve ser positiva")
    @Enumerated(EnumType.STRING)
    private UnidadeMedida unidadeMedida;
    @NotBlank
    private String categoria; //opções ver o que colocar
    @NotBlank
    private String status;
    @ManyToMany
    @JoinTable(
        name = "produto_materia_prima",
        joinColumns = @JoinColumn(name = "produto_id"),
        inverseJoinColumns = @JoinColumn(name = "materia_prima_id")
    )
    private Set<MateriaPrima> materiasPrimas;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }
    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }
    public Set<MateriaPrima> getMateriasPrimas() {
        return materiasPrimas;
    }
    public void setMateriasPrimas(Set<MateriaPrima> materiasPrimas) {
        this.materiasPrimas = materiasPrimas;
    }
}