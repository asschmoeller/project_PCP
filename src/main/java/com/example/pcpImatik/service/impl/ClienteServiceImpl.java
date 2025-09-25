package com.example.pcpImatik.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pcpImatik.Repository.ClienteRepository;
import com.example.pcpImatik.entity.Cliente;
import com.example.pcpImatik.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Cliente cliente) {
        repository.save(cliente);
    }

    @Override
    public void delete(Cliente cliente) {
        repository.delete(cliente);
    }

    @Override
    public List<Cliente> findByNome(String nome) {
        return repository.findByRazaoSocialContainingIgnoreCase(nome);
    }

    @Override
    public List<Cliente> findAllByIds(List<Long> ids) {
        return StreamSupport.stream(repository.findAllById(ids).spliterator(), false)
                .collect(Collectors.toList());
    }
}
