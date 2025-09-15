package com.example.pcpImatik.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pcpImatik.Repository.OperadorRepository;
import com.example.pcpImatik.entity.Operador;
import com.example.pcpImatik.service.OperadorService;

@Service
public class OperadorServiceImpl implements OperadorService {

    @Autowired
    private OperadorRepository repository;

    @Override
    public List<Operador> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Operador operador) {
        repository.save(operador);
    }

    @Override
    public void delete(Operador operador) {
        repository.delete(operador);
    }

    @Override
    public List<Operador> findByNome(String nome) {
        return repository.findByFuncionarioNomeFuncionarioContainingIgnoreCase(nome);
    }

    @Override
    public List<Operador> findAllByIds(List<Long> ids) {
        return StreamSupport.stream(repository.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
public Optional<Operador> findById(Long id) {
    return repository.findById(id);
}

}
