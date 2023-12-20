package com.soulcode.estudandospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soulcode.estudandospring.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
  
}
