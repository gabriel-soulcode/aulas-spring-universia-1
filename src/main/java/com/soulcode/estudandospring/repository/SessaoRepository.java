package com.soulcode.estudandospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soulcode.estudandospring.model.Sessao;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Integer> {
  
}
