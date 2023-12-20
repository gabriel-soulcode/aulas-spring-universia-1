package com.soulcode.estudandospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soulcode.estudandospring.model.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
  
}
