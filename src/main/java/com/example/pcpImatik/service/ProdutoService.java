package com.example.pcpImatik.service;

import java.util.List;

import com.example.pcpImatik.entity.Produto;

public interface ProdutoService {
    List<Produto> getAll();

    void save(Produto produto);

    void delete(Produto produto);

    List<Produto> findByNome(String nome); 

    List<Produto> findAllByIds(List<Long> ids);

}


