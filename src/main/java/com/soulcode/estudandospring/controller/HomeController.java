package com.soulcode.estudandospring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
  
  @GetMapping(value = {"/", "/home", "/h"})
  public String home() {
    return "Bem-vindo(a)!";
  }

  @GetMapping(value = "/contato")
  public String contato() {
    return "Página de Contato";
  }
}
