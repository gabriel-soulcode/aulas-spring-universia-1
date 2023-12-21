package com.soulcode.estudandospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
  
  @GetMapping(value = {"/", "/home", "/h"})
  public String home() {
    return "index";
  }

  @GetMapping(value = "/contato")
  public String contato() {
    return "contato";
  }
}
