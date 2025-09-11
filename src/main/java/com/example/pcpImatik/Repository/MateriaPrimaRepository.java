package com.example.pcpImatik.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pcpImatik.entity.MateriaPrima;

@Repository
public interface MateriaPrimaRepository
                extends JpaRepository<MateriaPrima, Long> {
       List<MateriaPrima> findByNomeMateriaPrimaContainingIgnoreCase(String nomeMateriaPrima);
}