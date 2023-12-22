package com.soulcode.estudandospring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soulcode.estudandospring.model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {
  
  @Query(value = "SELECT * FROM filmes WHERE classificao <> '18'", nativeQuery = true)
  List<Filme> findByClassicacao();
}
