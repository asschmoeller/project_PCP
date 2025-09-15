package com.example.pcpImatik.service;

import java.util.List;
import java.util.Optional;

import com.example.pcpImatik.entity.Operador;

public interface OperadorService {
    List<Operador> getAll();

    void save(Operador operador);

    void delete(Operador operador);

    List<Operador> findByNome(String nome);

    List<Operador> findAllByIds(List<Long> ids);

    Optional<Operador> findById(Long id);

}


