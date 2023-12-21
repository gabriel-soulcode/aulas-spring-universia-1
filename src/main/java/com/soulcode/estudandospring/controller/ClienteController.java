package com.soulcode.estudandospring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.soulcode.estudandospring.model.Cliente;
import com.soulcode.estudandospring.repository.ClienteRepository;

@Controller
public class ClienteController {

  @Autowired
  private ClienteRepository clienteRepository;
  
  @GetMapping(value = "/clientes")
  public ModelAndView clientes() {
    List<Cliente> clientes = clienteRepository.findAll();
    ModelAndView mv = new ModelAndView("clientes");
    mv.addObject("cls", clientes);
    return mv;
  }

  @GetMapping(value = "/clientes/{id}")
  public ModelAndView clientById(@PathVariable Integer id) {
    Optional<Cliente> clienteOpt = clienteRepository.findById(id);
    if(clienteOpt.isPresent()) {
      Cliente cliente = clienteOpt.get();
      ModelAndView mv = new ModelAndView("cliente");
      mv.addObject("cl", cliente);
      return mv;
    }
    else {
      ModelAndView erro = new ModelAndView("erro");
      return erro;
    }
  }

  @PostMapping(value = "/clientes/delete")
  public String delete(@RequestParam Integer id) {
    clienteRepository.deleteById(id);
    return "redirect:/clientes";
  }
}
