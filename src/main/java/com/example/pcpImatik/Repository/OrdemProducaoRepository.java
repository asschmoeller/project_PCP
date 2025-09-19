package com.example.pcpImatik.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pcpImatik.entity.OrdemProducao;

@Repository
public interface OrdemProducaoRepository
            extends JpaRepository<OrdemProducao, Long> {
      Optional<OrdemProducao> findById(long id);
}