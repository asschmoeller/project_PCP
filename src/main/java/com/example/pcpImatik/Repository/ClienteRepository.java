package com.example.pcpImatik.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pcpImatik.entity.Cliente;

@Repository
public interface ClienteRepository
                extends JpaRepository<Cliente, Long> {

}
