package com.example.pcpImatik.service;

import java.util.List;

import com.example.pcpImatik.entity.Fornecedor;

public interface FornecedorService {
    List<Fornecedor> getAll();

    void save(Fornecedor fornecedor);

    void delete(Fornecedor fornecedor);

    List<Fornecedor> findByNome(String nome);

    List<Fornecedor> findAllByIds(List<Long> ids);
}


