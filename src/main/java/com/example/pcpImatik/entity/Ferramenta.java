package com.example.pcpImatik.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity 
public class Ferramenta{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String nome;
    @NotNull (message = "A quantidade é obrigatória e deve ser positiva")
    @Min(value = 1, message = "A quantidade deve ser maior que zero")
    private int quantidade;
    @Enumerated(EnumType.STRING)
    private TipoManFerramenta tipoManFerramenta;
    @NotNull (message = "A vida útil é obrigatória e deve ser positiva")
    @Min(value = 1, message = "A quantidade deve ser maior que zero")
    private int vidaUtil;
    @NotBlank
    private String localizacao;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public TipoManFerramenta getTipoManFerramenta() {
        return tipoManFerramenta;
    }
    public void setTipoManFerramenta(TipoManFerramenta tipoManFerramenta) {
        this.tipoManFerramenta = tipoManFerramenta;
    }
    public int getVidaUtil() {
        return vidaUtil;
    }
    public void setVidaUtil(int vidaUtil) {
        this.vidaUtil = vidaUtil;
    }
    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
       
}