package com.soulcode.estudandospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soulcode.estudandospring.model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {
  
}
