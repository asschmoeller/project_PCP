package com.example.pcpImatik.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pcpImatik.Repository.OrdemProducaoRepository;
import com.example.pcpImatik.entity.OrdemProducao;
import com.example.pcpImatik.service.OrdemProducaoService;

@Service
public class OrdemProducaoServiceImpl implements OrdemProducaoService {

    @Autowired
    private OrdemProducaoRepository repository;

    @Override
    public List<OrdemProducao> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(OrdemProducao ordemProducao) {
        repository.save(ordemProducao);
    }

    @Override
    public void delete(OrdemProducao ordemProducao) {
        repository.delete(ordemProducao);
    }

    @Override
    public Optional<OrdemProducao> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<OrdemProducao> findAllByIds(List<Long> ids) {
        return StreamSupport.stream(repository.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }

}
