package com.example.pcpImatik.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity 
public class MateriaPrima{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String nomeMateriaPrima;
    @NotNull (message = "A Unidade de medida é obrigatória e deve ser positiva")
    @Enumerated(EnumType.STRING)
    private UnidadeMedida unidadeMedida;
    @NotNull (message = "O Preço Atual é obrigatório e deve ser positivo")
    @DecimalMin(value = "0.1", inclusive = true, message = "O preço atual deve ser maior que zero")
    @Positive (message = "O valor deve ser positivo")
    private Float precoAtual;
    @NotNull(message = "A quantidade atual é obrigatória e deve ser positiva")
    @Min(value = 1, message = "A quantidade deve ser maior que zero")
    private Integer quantidadeAtual;
    @NotBlank
    private String fornecedorPrincipal; //puxar de fornecedores
    @NotNull
    private LocalDate dataUltimaCompra;
    @NotNull(message = "O estoque mínimo é obrigatório e deve ser positivo")
    @Min(value = 1, message = "O estoque mínimo deve ser maior que zero")
    private Integer estoqueMinimo;

    @OneToMany(mappedBy = "materiaProdutoId.materiaPrima", cascade = CascadeType.ALL, orphanRemoval = true)
private Set<MateriaPrimaProduto> materiaPrimaProdutos = new HashSet<>();


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNomeMateriaPrima() {
        return nomeMateriaPrima;
    }
    public void setNomeMateriaPrima(String nomeMateriaPrima) {
        this.nomeMateriaPrima = nomeMateriaPrima;
    }
    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }
    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }
    public Float getPrecoAtual() {
        return precoAtual;
    }
    public void setPrecoAtual(float precoAtual) {
        this.precoAtual = precoAtual;
    }
    public Integer getQuantidadeAtual() {
        return quantidadeAtual;
    }
    public void setQuantidadeAtual(int quantidadeAtual) {
        this.quantidadeAtual = quantidadeAtual;
    }
    public String getFornecedorPrincipal() {
        return fornecedorPrincipal;
    }
    public void setFornecedorPrincipal(String fornecedorPrincipal) {
        this.fornecedorPrincipal = fornecedorPrincipal;
    }
    public LocalDate getDataUltimaCompra() {
        return dataUltimaCompra;
    }
    public void setDataUltimaCompra(LocalDate dataUltimaCompra) {
        this.dataUltimaCompra = dataUltimaCompra;
    }
    public Integer getEstoqueMinimo() {
        return estoqueMinimo;
    }
    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }
}