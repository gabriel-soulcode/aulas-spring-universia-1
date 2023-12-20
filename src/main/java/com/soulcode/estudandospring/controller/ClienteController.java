package com.soulcode.estudandospring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.soulcode.estudandospring.model.Cliente;
import com.soulcode.estudandospring.repository.ClienteRepository;

@RestController
public class ClienteController {

  @Autowired
  private ClienteRepository clienteRepository;
  
  @GetMapping(value = "/clientes")
  public String clientes() {
    return "Página de Clientes";
  }

  @GetMapping(value = "/clientes/{id}")
  public String clientById(@PathVariable Integer id) {
    Optional<Cliente> clienteOpt = clienteRepository.findById(id);
    if(clienteOpt.isPresent()) {
      Cliente cliente = clienteOpt.get();
      return cliente.getNome();
    }
    else {
      return "Cliente não encontrado";
    }
  }
}
