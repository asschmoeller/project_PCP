package com.example.pcpImatik.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pcpImatik.Repository.EquipamentoRepository;
import com.example.pcpImatik.entity.Equipamento;
import com.example.pcpImatik.service.EquipamentoService;

@Service
public class EquipamentoServiceImpl implements EquipamentoService {

    @Autowired
    private EquipamentoRepository repository;

    @Override
    public List<Equipamento> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Equipamento equipamento) {
        repository.save(equipamento);
    }

    @Override
    public void delete(Equipamento equipamento) {
        repository.delete(equipamento);
    }

    @Override
    public List<Equipamento> findByNome(String nome) {
        return repository.findByNomeEquipamentoContainingIgnoreCase(nome);
    }

    @Override
    public List<Equipamento> findAllByIds(List<Long> ids) {
        return StreamSupport.stream(repository.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }
}
