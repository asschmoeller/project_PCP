package com.example.pcpImatik.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity 
public class Fornecedor{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull (message = "o CNPJ é obrigatório")
    private long CNPJ;
    @NotBlank
    private String razaoSocial;
    @NotBlank
    private String nomeFantasia;
    @NotBlank
    private String endereco;
    @NotBlank
    private String telefone;
    @NotBlank
    private String email;
    @NotBlank
    private String pessoaContato;
    @Enumerated(EnumType.STRING)
    private TipoFornecedor tipoFornecedor;
    @NotBlank
    private String status;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getCNPJ() {
        return CNPJ;
    }
    public void setCNPJ(long cNPJ) {
        CNPJ = cNPJ;
    }
    public String getRazaoSocial() {
        return razaoSocial;
    }
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    public String getNomeFantasia() {
        return nomeFantasia;
    }
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPessoaContato() {
        return pessoaContato;
    }
    public void setPessoaContato(String pessoaContato) {
        this.pessoaContato = pessoaContato;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public TipoFornecedor getTipoFornecedor() {
        return tipoFornecedor;
    }
    public void setTipoFornecedor(TipoFornecedor tipoFornecedor) {
        this.tipoFornecedor = tipoFornecedor;
    }
}