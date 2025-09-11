package com.example.pcpImatik.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pcpImatik.entity.Produto;

@Repository
public interface ProdutoRepository
                extends JpaRepository<Produto, Long> {
       List<Produto> findByNomeProdutoContainingIgnoreCase(String nomeProduto);
}