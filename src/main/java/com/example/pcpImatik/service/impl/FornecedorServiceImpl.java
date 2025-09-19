package com.example.pcpImatik.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pcpImatik.Repository.FornecedorRepository;
import com.example.pcpImatik.entity.Fornecedor;
import com.example.pcpImatik.service.FornecedorService;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    @Override
    public List<Fornecedor> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Fornecedor fornecedor) {
        repository.save(fornecedor);
    }

    @Override
    public void delete(Fornecedor fornecedor) {
        repository.delete(fornecedor);
    }

    @Override
    public List<Fornecedor> findByNome(String nome) {
        return repository.findByRazaoSocialContainingIgnoreCase(nome);
    }

    @Override
    public List<Fornecedor> findAllByIds(List<Long> ids) {
        return StreamSupport.stream(repository.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }
}
