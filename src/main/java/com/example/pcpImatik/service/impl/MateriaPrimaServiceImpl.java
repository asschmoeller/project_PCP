package com.example.pcpImatik.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pcpImatik.Repository.MateriaPrimaRepository;
import com.example.pcpImatik.entity.MateriaPrima;
import com.example.pcpImatik.service.MateriaPrimaService;

@Service
public class MateriaPrimaServiceImpl implements MateriaPrimaService {

    @Autowired
    private MateriaPrimaRepository repository;

    @Override
    public List<MateriaPrima> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(MateriaPrima materiaPrima) {
        repository.save(materiaPrima);
    }

    @Override
    public void delete(MateriaPrima materiaPrima) {
        repository.delete(materiaPrima);
    }

    @Override
    public List<MateriaPrima> findByNome(String nome) {
        return repository.findByNomeMateriaPrimaContainingIgnoreCase(nome);
    }

    @Override
    public List<MateriaPrima> findAllByIds(List<Long> ids) {
        return StreamSupport.stream(repository.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }
}
