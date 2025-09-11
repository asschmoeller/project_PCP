package com.example.pcpImatik.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pcpImatik.Repository.FuncionarioRepository;
import com.example.pcpImatik.entity.Funcionario;
import com.example.pcpImatik.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    @Override
    public List<Funcionario> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Funcionario funcionario) {
        repository.save(funcionario);
    }

    @Override
    public void delete(Funcionario funcionario) {
        repository.delete(funcionario);
    }

    @Override
    public List<Funcionario> findByNome(String nome) {
        return repository.findByNomeFuncionarioContainingIgnoreCase(nome);
    }

    @Override
    public List<Funcionario> findAllByIds(List<Long> ids) {
        return StreamSupport.stream(repository.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }
}
