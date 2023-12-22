package com.soulcode.estudandospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    List<Sessao> sessoes = sessaoRepository.findAll();
    List<Filme> filmes = filmeRepository.findAll();
    ModelAndView mv = new ModelAndView("sessoes");
    mv.addObject("ses", sessoes);
    mv.addObject("fils", filmes);
    return mv;
  }
}
