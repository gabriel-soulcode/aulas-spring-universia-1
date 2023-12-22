package com.soulcode.estudandospring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.soulcode.estudandospring.model.Sessao;
import com.soulcode.estudandospring.model.Cliente;
import com.soulcode.estudandospring.model.Reserva;
import com.soulcode.estudandospring.repository.SessaoRepository;
import com.soulcode.estudandospring.repository.ClienteRepository;
import com.soulcode.estudandospring.repository.ReservaRepository;

@Controller
public class ReservaController {
  
  @Autowired
  private ReservaRepository reservaRepository;

  @Autowired
  private SessaoRepository sessaoRepository;

  @Autowired
  private ClienteRepository clienteRepository;

  @GetMapping(value = "/reservas")
  public ModelAndView reservas() {
    try {
      List<Reserva> reservas = reservaRepository.findAll();
      List<Sessao> sessaos = sessaoRepository.findAll();
      List<Cliente> clientes = clienteRepository.findAll();
      ModelAndView mv = new ModelAndView("reservas");
      mv.addObject("resvs", reservas);
      mv.addObject("ses", sessaos);
      mv.addObject("cls", clientes);
      return mv;
    } catch(Exception ex) {
      ModelAndView erro = new ModelAndView("erro");
      erro.addObject("msg", "Erro interno no servidor.");
      return erro;
    }
  }

  @PostMapping(value = "/reservas")
  public String create(@RequestParam Integer sessaoId, @RequestParam Integer clienteId, Reserva reserva) {
    try {
      Optional<Sessao> sessaoOpt = sessaoRepository.findById(sessaoId);
      Optional<Cliente> clienteOpt = clienteRepository.findById(clienteId);
      if(sessaoOpt.isPresent() && clienteOpt.isPresent()) {
        Sessao sessao = sessaoOpt.get();
        Cliente cliente = clienteOpt.get();
        reserva.setSessao(sessao);
        reserva.setCliente(cliente);
        reservaRepository.save(reserva);
      }
      return "redirect:/reservas";
    } catch(Exception ex) {
      return "erro";
    }
  }

  @PostMapping(value = "/reservas/delete")
  public String delete(@RequestParam Integer id) {
    try {
      reservaRepository.deleteById(id);
      return "redirect:/reservas";
    } catch(Exception ex) {
      return "erro";
    }
  }
}
