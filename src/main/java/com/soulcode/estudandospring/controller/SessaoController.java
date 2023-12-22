package com.soulcode.estudandospring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.soulcode.estudandospring.model.Filme;
import com.soulcode.estudandospring.model.Sessao;
import com.soulcode.estudandospring.repository.FilmeRepository;
import com.soulcode.estudandospring.repository.SessaoRepository;

@Controller
public class SessaoController {
  
  @Autowired
  private SessaoRepository sessaoRepository;

  @Autowired
  private FilmeRepository filmeRepository;

  @GetMapping(value = "/sessoes")
  public ModelAndView sessoes() {
    try {
      List<Sessao> sessoes = sessaoRepository.findAll();
      List<Filme> filmes = filmeRepository.findAll();
      ModelAndView mv = new ModelAndView("sessoes");
      mv.addObject("ses", sessoes);
      mv.addObject("fils", filmes);
      return mv;
    } catch(Exception ex) {
      ModelAndView erro = new ModelAndView("erro");
      erro.addObject("msg", "Erro interno no servidor.");
      return erro;
    }
  }

  @PostMapping(value = "/sessoes")
  public String create(@RequestParam Integer filmeId, Sessao sessao) {
    try {
      Optional<Filme> filmeOpt = filmeRepository.findById(filmeId);
      if(filmeOpt.isPresent()) {
        Filme filme = filmeOpt.get();
        sessao.setFilme(filme);
        sessaoRepository.save(sessao);
      }
      return "redirect:/sessoes";
    } catch(Exception ex) {
      return "erro";
    }
  }

  @PostMapping(value = "/sessoes/delete")
  public String delete(@RequestParam Integer id) {
    try {
      sessaoRepository.deleteById(id);
      return "redirect:/sessoes";
    } catch(Exception ex) {
      return "erro";
    }
  }
}
