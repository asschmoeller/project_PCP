package com.example.pcpImatik.service;

import java.util.List;

import com.example.pcpImatik.entity.Equipamento;

public interface EquipamentoService {
    List<Equipamento> getAll();

    void save(Equipamento equipamento);

    void delete(Equipamento equipamento);

    List<Equipamento> findByNome(String nome); 

    List<Equipamento> findAllByIds(List<Long> ids);
}


