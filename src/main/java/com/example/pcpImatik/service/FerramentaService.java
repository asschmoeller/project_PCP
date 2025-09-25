package com.example.pcpImatik.service;

import java.util.List;

import com.example.pcpImatik.entity.Ferramenta;

public interface FerramentaService {
    List<Ferramenta> getAll();

    void save(Ferramenta cliente);

    void delete(Ferramenta cliente);

    List<Ferramenta> findByNome(String nome);

    List<Ferramenta> findAllByIds(List<Long> ids);

}
