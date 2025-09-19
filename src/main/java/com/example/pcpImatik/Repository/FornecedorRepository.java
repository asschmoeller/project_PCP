package com.example.pcpImatik.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pcpImatik.entity.Fornecedor;

@Repository
public interface FornecedorRepository
                extends JpaRepository<Fornecedor, Long> {
       List<Fornecedor> findByRazaoSocialContainingIgnoreCase(String razaoSocial);
}