package com.example.pcpImatik.service;

import java.util.List;

import com.example.pcpImatik.entity.Cliente;

public interface ClienteService {
    List<Cliente> getAll();

    void save(Cliente cliente);

    void delete(Cliente cliente);

}
