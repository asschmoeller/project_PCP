package com.example.pcpImatik.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pcpImatik.entity.Ferramenta;

@Repository
public interface FerramentaRepository
                extends JpaRepository<Ferramenta, Long> {
       List<Ferramenta> findByNomeContainingIgnoreCase(String nome);
}
