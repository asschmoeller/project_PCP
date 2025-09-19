package com.example.pcpImatik.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MateriaPrimaProdutoId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "materia_prima_id", nullable = false)
    private MateriaPrima materiaPrima;

    // Construtores, getters e setters
    public MateriaPrimaProdutoId() {}

    public MateriaPrimaProdutoId(Produto produto, MateriaPrima materiaPrima) {
        this.produto = produto;
        this.materiaPrima = materiaPrima;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(MateriaPrima materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MateriaPrimaProdutoId)) return false;
        MateriaPrimaProdutoId that = (MateriaPrimaProdutoId) o;
        return Objects.equals(produto.getId(), that.produto.getId()) &&
               Objects.equals(materiaPrima.getId(), that.materiaPrima.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(produto.getId(), materiaPrima.getId());
    }
}
