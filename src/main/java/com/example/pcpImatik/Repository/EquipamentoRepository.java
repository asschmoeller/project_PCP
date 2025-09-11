package com.example.pcpImatik.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pcpImatik.entity.Equipamento;

@Repository
public interface EquipamentoRepository
                extends JpaRepository<Equipamento, Long> {
       List<Equipamento> findByNomeEquipamentoContainingIgnoreCase(String nomeEquipamento);
}