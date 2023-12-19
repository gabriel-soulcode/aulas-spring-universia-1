package com.soulcode.estudandospring.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false, length = 100)
  private String nome;

  @Column(nullable = false, length = 120)
  private String email;

  @Column(nullable = false, length = 50)
  private String preferencia;

  @Column(nullable = false)
  private LocalDate filiacao;

  public Cliente() {

  }
  
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPreferencia() {
    return preferencia;
  }

  public void setPreferencia(String preferencia) {
    this.preferencia = preferencia;
  }

  public LocalDate getFiliacao() {
    return filiacao;
  }

  public void setFiliacao(LocalDate filiacao) {
    this.filiacao = filiacao;
  }
}
