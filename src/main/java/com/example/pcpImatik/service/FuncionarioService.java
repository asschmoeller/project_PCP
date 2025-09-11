package com.example.pcpImatik.service;

import java.util.List;

import com.example.pcpImatik.entity.Funcionario;

public interface FuncionarioService {
    List<Funcionario> getAll();

    void save(Funcionario funcionario);

    void delete(Funcionario funcionario);

    List<Funcionario> findByNome(String nome);

    List<Funcionario> findAllByIds(List<Long> ids);
}


