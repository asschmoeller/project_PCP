package com.example.pcpImatik.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class MateriaPrimaProduto {

    @EmbeddedId
    private MateriaPrimaProdutoId materiaProdutoId;

    private Double quantity;

    public MateriaPrimaProduto() {}

    public MateriaPrimaProduto(MateriaPrimaProdutoId materiaProdutoId, Double quantity) {
        this.materiaProdutoId = materiaProdutoId;
        this.quantity = quantity;
    }

    public MateriaPrimaProdutoId getMateriaProdutoId() {
        return materiaProdutoId;
    }

    public void setMateriaProdutoId(MateriaPrimaProdutoId materiaProdutoId) {
        this.materiaProdutoId = materiaProdutoId;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MateriaPrimaProduto)) return false;
        MateriaPrimaProduto that = (MateriaPrimaProduto) o;
        return Objects.equals(materiaProdutoId, that.materiaProdutoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(materiaProdutoId);
    }
}
