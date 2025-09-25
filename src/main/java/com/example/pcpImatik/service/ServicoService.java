package com.example.pcpImatik.service;

import java.util.List;

import com.example.pcpImatik.entity.Servico;

public interface ServicoService {
    List<Servico> getAll();

    void save(Servico servico);

    void delete(Servico servico);

    List<Servico> findByNome(String nome);

    List<Servico> findAllByIds(List<Long> ids);

}
