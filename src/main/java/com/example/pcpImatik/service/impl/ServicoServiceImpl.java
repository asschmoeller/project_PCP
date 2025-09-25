package com.example.pcpImatik.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pcpImatik.Repository.ServicoRepository;
import com.example.pcpImatik.entity.Servico;
import com.example.pcpImatik.service.ServicoService;

@Service
public class ServicoServiceImpl implements ServicoService {

    @Autowired
    private ServicoRepository repository;

    @Override
    public List<Servico> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Servico servico) {
        repository.save(servico);
    }

    @Override
    public void delete(Servico servico) {
        repository.delete(servico);
    }

    @Override
    public List<Servico> findByNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    @Override
    public List<Servico> findAllByIds(List<Long> ids) {
        return StreamSupport.stream(repository.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }
}
