package com.example.pcpImatik.service;

import java.util.List;

import com.example.pcpImatik.entity.MateriaPrima;

public interface MateriaPrimaService {
    List<MateriaPrima> getAll();

    void save(MateriaPrima materiaPrima);

    void delete(MateriaPrima materiaPrima);

    List<MateriaPrima> findByNome(String nome);

    List<MateriaPrima> findAllByIds(List<Long> ids);
}


