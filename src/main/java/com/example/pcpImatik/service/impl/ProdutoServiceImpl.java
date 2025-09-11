package com.example.pcpImatik.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pcpImatik.Repository.ProdutoRepository;
import com.example.pcpImatik.entity.Produto;
import com.example.pcpImatik.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Override
    public List<Produto> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Produto produto) {
        repository.save(produto);
    }

    @Override
    public void delete(Produto produto) {
        repository.delete(produto);
    }

    @Override
    public List<Produto> findByNome(String nome) {
        return repository.findByNomeProdutoContainingIgnoreCase(nome);
    }

    @Override
    public List<Produto> findAllByIds(List<Long> ids) {
        return StreamSupport.stream(repository.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }

}
