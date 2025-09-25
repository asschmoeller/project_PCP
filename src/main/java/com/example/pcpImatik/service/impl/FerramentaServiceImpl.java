package com.example.pcpImatik.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pcpImatik.Repository.FerramentaRepository;
import com.example.pcpImatik.entity.Ferramenta;
import com.example.pcpImatik.service.FerramentaService;

@Service
public class FerramentaServiceImpl implements FerramentaService {

    @Autowired
    private FerramentaRepository repository;

    @Override
    public List<Ferramenta> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Ferramenta ferramenta) {
        repository.save(ferramenta);
    }

    @Override
    public void delete(Ferramenta ferramenta) {
        repository.delete(ferramenta);
    }

    @Override
    public List<Ferramenta> findByNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    @Override
    public List<Ferramenta> findAllByIds(List<Long> ids) {
        return StreamSupport.stream(repository.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }
}
