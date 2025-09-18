package com.example.pcpImatik.service;

import java.util.List;
import java.util.Optional;

import com.example.pcpImatik.entity.OrdemProducao;

public interface OrdemProducaoService {
    List<OrdemProducao> getAll();

    void save(OrdemProducao ordemProducao);

    void delete(OrdemProducao ordemProducao);

    Optional<OrdemProducao> findById(Long id);

    List<OrdemProducao> findAllByIds(List<Long> ids);

}


