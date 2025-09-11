package com.example.pcpImatik.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Cliente{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String cnpj;
    private String nome;
    private String razao_social;
    private String endereco;
    private String telefone;
    private String email;
    private String pessoa_contato;
    private String status;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }
    public String getRazao_social() {
        return razao_social;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setPessoa_contato(String pessoa_contato) {
        this.pessoa_contato = pessoa_contato;
    }
    public String getPessoa_contato() {
        return pessoa_contato;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}