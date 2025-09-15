package com.example.pcpImatik.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pcpImatik.entity.Operador;

@Repository
public interface OperadorRepository
                extends JpaRepository<Operador, Long> {
      List<Operador> findByFuncionarioNomeFuncionarioContainingIgnoreCase(String nomeFuncionario);
}