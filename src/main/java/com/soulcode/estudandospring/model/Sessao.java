package com.soulcode.estudandospring.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sessoes")
public class Sessao {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private LocalDate data;

  @Column(nullable = false)
  private LocalTime inicio;

  @Column(nullable = false)
  private LocalTime termino;

  @Column(name = "preco_ingresso", nullable = false)
  private Float precoIngresso;

  @ManyToOne
  @JoinColumn(nullable = false)
  private Filme filme;

  public Sessao() {

  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public LocalDate getData() {
    return data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public LocalTime getInicio() {
    return inicio;
  }

  public void setInicio(LocalTime inicio) {
    this.inicio = inicio;
  }

  public LocalTime getTermino() {
    return termino;
  }

  public void setTermino(LocalTime termino) {
    this.termino = termino;
  }

  public Float getPrecoIngresso() {
    return precoIngresso;
  }

  public void setPrecoIngresso(Float precoIngresso) {
    this.precoIngresso = precoIngresso;
  }

  public Filme getFilme() {
    return filme;
  }

  public void setFilme(Filme filme) {
    this.filme = filme;
  }
}
